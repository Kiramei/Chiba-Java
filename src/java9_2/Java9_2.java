/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * プロジェクト: Java9_2, パッケージ: java9_2, クラス: Java9_2
 * 学校番号：24z1e146
 */

//プロジェクト: java9_2, パッケージ: java9_2, クラス: Java9_2
package java9_2;

public class Java9_2 {
    public static void main(String[] args) {
        int a, b, c;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            c = a / b;
            System.out.println(args[0] + " / " + args[1] + " = " + c);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("引数は二つ必要です");
        } catch (ArithmeticException e) {
            // 算術エラーの例外処理
            // 例えば、入力パラメータは5, 0の場合、これが起これる
            System.err.println("算術エラーです");
        } catch (NumberFormatException e) {
            // フォマットエラーの例外処理、整数でない場合
            //　例えば、入力パラメータはa, bの場合、これが起これる
            System.err.println("引数は整数でなければなりません");
        } finally {
            System.err.println("プログラムは正常終了しました");
        }
    }
}