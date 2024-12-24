/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * 初の宿題：関数の商と余りを計算するプログラムを作成すること
 * 学校番号：24z1e146
 */


/* 最初、入力すること必要なライブを導入すること */

import java.util.*;
/* もう一つの入力方法必要なライブ */
// import java.io.*;

// クラスの宣言。注意：クラス名とファイル名は一致すること
public class Homework1 {
    public static void main(String[] args) {
        try {
            /* 入力機能を起用せよう */
            Scanner sc = new Scanner(System.in);

            System.out.println("こんにちは！商と余りを計算するプログラムです！");
            /* 初の数を入力することとその提示 */
            System.out.print("二つの数を入力してください、先ずは数A: ");
            int first_number = sc.nextInt();

            /* 第二の数を入力することとその提示 */
            System.out.print("そして、すうB: ");
            int second_number = sc.nextInt();

            /* 計算すること */
            int division = first_number / second_number; // ここで注意：Javaは整数の除算を行うと、商は整数となります。小数は切り捨てられます
            int mod = first_number % second_number;

            /* 結果を表すこと */
            System.out.println("a / b、その商は: " + division);
            System.out.println("a / b、その余りは: " + mod);

            /* 入力機能を閉じること */
            sc.close();

            /* 例外処理 */
        } catch (ArithmeticException e) {
            System.out.println("0で割ることはできません! ");
        } catch (InputMismatchException e) {
            System.out.println("入力の形式が間違っています! ");
        } catch (Exception e) {
            System.out.println("エラーが発生しました! ");
        }
        /* もう一つの入力方法 */
        /*
         * try {
         *     // インプットストリームを起用すること
         *     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         *     System.out.print("二つの数を入力してください、先ずは数A：");
         *     int first_number = Integer.parseInt(br.readLine());
         *     System.out.print("そして、すうB：");
         *     int second_number = Integer.parseInt(br.readLine());
         *     int division = first_number / second_number;
         *     int mod = first_number % second_number;
         *     System.out.println("a　/　b、その商は：\t" + division);
         *     System.out.println("a　/　b、その余りは：\t" + mod);
         * } catch (ArithmeticException e){
         *     System.out.println("0で割ることはできません！");
         * } catch (InputMismatchException e){
         *     System.out.println("入力の形式が間違っています！");
         * } catch (Exception e){
         *     System.out.println("エラーが発生しました！");
         * }
         */
    }
}

/*
  このプログラムは、二つの数を入力することを要求し、その商と余りを計算することを行います。
  でも実行する条件があります：
  1. 二つの数を入力すること
  2. 0で割ることはできません
  3. 入力の形式が間違っていることはできません
  4. その他のエラーが発生した場合、エラーが発生しましたと表示すること
  5. 大すぎる数を入力することはできません。その場合、このプログラムは正しく動作しないかもしれません
  　　　（例えば、数値がintの範囲を超える場合。BigIntegerを使うことで解決できるかもしれません）
 */