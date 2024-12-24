package enshu12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Enshu12 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            System.err.println("ファイルが開けません");
            System.err.println(e.getMessage());
            return;
        }
        // ↓修正箇所ここから
        
        LinkedList<Note> eventList = new LinkedList<>();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                eventList.add(new Note(Double.parseDouble(item[0]), Integer.parseInt(item[1]), Integer.parseInt(item[2])));
                if (item.length == 4)
                    new Note(Double.parseDouble(item[3]) + Double.parseDouble(item[0]), Integer.parseInt(item[1]), 0);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("入出力エラーがあります");
        }
        eventList.sort(new ListComparator());

        // 下の書き方は最も簡単と思います。
        // eventList.sort(Comparator.comparingDouble(Note::getTime));

        // 上記のコメントアウトを復元して並べ替えを行う
        // ListComparator は別途記述する必要あり
        // ↑修正箇所ここまで

        try {
            while (true) {
                eventPlay(eventList);
            }
        } catch (Exception e) {
            System.err.println("エラーが発生しました。");
        }
    }

    static void eventPlay(LinkedList<Note> eventList) throws Exception {
        MySynthesizer syn = new MySynthesizer(); // シンセサイザを準備
        syn.setInst(0, 10); // 楽器の指定 (General MIDI: 1-128)
        // 49: String Ensemble 1

        Thread.sleep(500); // 冒頭の音が切れることがあるので500ms待機
        long start = System.nanoTime(); // 開始時刻の取得(ナノ秒単位)
        double now; // 時刻用(ミリ秒単位)
        for (Iterator<Note> it = eventList.iterator(); it.hasNext(); ) {
            Note item = it.next();
            while (true) {
                now = (System.nanoTime() - start) / 1000000000.0;
                // 現在時刻を計算(単位:秒)
                if (now >= item.getTime()) {
                    // イベントが現在時刻を過ぎていたら音を出力する
                    syn.noteOn(0, item); // 音を1音鳴らす (channel 0)
                    System.out.printf("%5.2f %3d %3d\n", now, item.getNoteNum(), item.getVelocity()); // 画面にログ出力
                    break;
                }
                Thread.sleep(1); // 1msスリープ(1msに1回上記のループを回すため)
            }
        }
        Thread.sleep(1000); // データをすべて出力させるため、1秒待つ
        syn.close(); // シンセサイザをクローズ
    }
}