//プロジェクト: enshu10, パッケージ: enshu10, クラス: Enshu10
package enshu10;

import java.io.*;

public class Enshu10 {
    public static void main(String[] args) throws IOException {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        int score;
        while (true) {
            System.out.print("得点を入力してください: ");
            String line = br.readLine();
            try {
                score = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("入力は整数でなければなりません\n");
                continue;
            }
            try {
                System.out.println("評価は" + Hyouka.getHyouka(score) + "です");
                // getHyoukaはstaticメソッドなのでインスタンス化なしで使用可
                break;
                // getHyoukaメソッドが正常終了した場合は無限ループを抜ける
            } catch (ScoreException e) {
                System.out.print("点数の入力に誤りがあります。");
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}