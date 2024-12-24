package java11_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Java11_6 {
    public static void main(String[] args) {
        BufferedReader br = null; // データ読み込み用
        BufferedWriter bw = null; // データ書き出し用
        ArrayList<F1Driver> f1_driver = new ArrayList<F1Driver>();
        // データ保存用リスト
        try {
            br = new BufferedReader(new FileReader(args[0]));
            bw = new BufferedWriter(new FileWriter(args[1]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("引数は入力ファイル,出力ファイルの二つが必要です");
            return;
        } catch (FileNotFoundException e) {
            // ファイルが開けない場合のエラー対応は必須(チェック例外)
            System.err.println("ファイルが開けません");
            System.err.println(e.getMessage());
            return;
        } catch (IOException e) { // IOExceptionはチェック例外
            System.err.println("入出力エラーがあります");
            return;
        }
        String str; // 文字列保存用
        try {
            while ((str = br.readLine()) != null) {
                /* ファイルから1行分のデータを文字列として読み込む */
                String[] str_array = str.split(",");
                /* 指定された区切り文字で文字列を分割する。上記の例では","
                で分割し、分割された結果は文字列クラスの配列に代入される。
                分割された要素数は配列の大きさで確認できる */
                F1Driver new_driver = new F1Driver(Integer.parseInt(str_array[0]), str_array[1], str_array[2], str_array[3], Integer.parseInt(str_array[4]), Integer.parseInt(str_array[5]));
                // 読み込まれたドライバーの情報を持つ新しいオブジェクトを生成
                f1_driver.add(new_driver);
                // 新しいオブジェクトをリストに追加
            }
            br.close(); // 読み込み用ファイルを閉じる
        } catch (IOException e) { // IOExceptionはチェック例外
            System.err.println("入出力エラーがあります");
        }
        try {

            // ポイントの合計値を保存する変数
            int totalPoints = 0;

            // チェックする対象国籍のリスト。ここでは「フランス」と「イギリス」
            final String[] NATIONALITY_LIST = new String[]{"France", "United Kingdom"};

            // F1Driverリストに含まれる各ドライバーに対してループ処理を行う
            for (F1Driver f1Driver : f1_driver) {
                // ドライバーの国籍を取得する
                String nationality = f1Driver.getNationality();

                // ドライバーの国籍が対象リストに含まれている場合の条件分岐
                if (Arrays.asList(NATIONALITY_LIST).contains(nationality)) {
                    // ドライバーのデータをcsv形式の文字列として出力ファイルに書き込む
                    bw.write(f1Driver.outputString());
                    // ドライバーの情報を整形して画面に表示する
                    f1Driver.printDriver();
                    // ドライバーのポイントを合計値に加算する
                    totalPoints += f1Driver.getPoint();
                }
            }

            // 合計ポイントを画面に表示する
            System.out.println("フランス人とイギリス人のドライバーのポイント合計は " + totalPoints + " です");

            bw.close(); // 出力用ファイルを閉じる
        } catch (IOException e) {
            // IOExceptionはチェック例外
            System.err.println("入出力エラーがあります");
        }
    }
}