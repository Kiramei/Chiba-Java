package enshu12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * 初の宿題：貯金計算プログラム
 * 学生証番号：24z1e146
 */

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

        // Noteオブジェクトを格納するためのLinkedListを作成
        LinkedList<Note> eventList = new LinkedList<>();
        String line;

        try {
            // BufferedReaderから1行ずつ読み込む
            while ((line = br.readLine()) != null) {
                // カンマ区切りの文字列を分割して配列に変換
                String[] item = line.split(",");

                // ファイル形式が正しいかをアサートで確認（最低3つの要素が必要）
                assert item.length >= 3 : "FILE FORMAT IS NOT SUPPORTED";

                // 配列から音符のピッチと強さを解析
                int notePitch = Integer.parseInt(item[1]);
                int strength = Integer.parseInt(item[2]);

                // 基本的なNoteオブジェクトを作成し、eventListに追加
                Note baseNote = new Note(Double.parseDouble(item[0]), notePitch, strength);
                eventList.add(baseNote);

                // 配列の長さが4の場合、持続時間フィールドが含まれている
                if (item.length == 4) {
                    // 持続時間を解析し、終了時間のNoteオブジェクト（強さ0）を作成して追加
                    double duration = Double.parseDouble(item[3]);
                    eventList.add(new Note(duration + baseNote.getTime(), notePitch, 0));
                }
            }

            // BufferedReaderを閉じる
            br.close();
        } catch (IOException e) {
            // 入出力エラーを捕捉して処理
            System.err.println("入出力エラーがあります");
        }

        // eventListをListComparatorでソート
        eventList.sort(new ListComparator());

        // 下の書き方は最も簡単と思います。
        // eventList.sort(Comparator.comparingDouble(Note::getTime));

        // 上記のコメントアウトを復元して並べ替えを行う
        // ListComparator は別途記述する必要あり
        // ↑修正箇所ここまで

        try {
            eventPlay(eventList);
        } catch (Exception e) {
            System.err.println("エラーが発生しました。");
        }
    }

    static void eventPlay(LinkedList<Note> eventList) throws Exception {
        MySynthesizer syn = new MySynthesizer(); // シンセサイザを準備
        syn.setInst(0, 49); // 楽器の指定 (General MIDI: 1-128)
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