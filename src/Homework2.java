/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * 初の宿題：貯金計算プログラム
 * 学生証番号：24z1e146
 */


public class Homework2 {
    // 利率は 1%
    public static final double INTEREST_RATE = 0.01d;

    public static void main(String[] args) {
        // 最初の預金は　100,000円、ネームは base
        // 現在の残高は 0円、ネームは current
        double base = 100000.0, current = 0.0;
        // 10年間の貯金計算、年は 0年から始まる
        int year = 0;
        while (year < 10) {
            // 1年後の貯金合計は、元の貯金合計に利率を加えたもの
            current = current + base;
            // 1年後の貯金合計は、元の貯金合計に利率を加えたもの
            current = current + current * INTEREST_RATE;
            // 結果を表すこと。年は 1年進む
            System.out.println(++year + "年目の貯金合計は" + current + "円です");
        }
        // calculateSavings(100000.0, 10);
    }

    /**
     * 方法②、再帰関数を利用すること
     *
     * @param base 最初の預金
     * @param year 年数
     * @return 貯金合計
     */

    public static double calculateSavings(double base, int year) {
        if (year == 0) return base;
        // 1年後の貯金合計は、元の貯金合計に利率を加えたもの
        // 年は 1年進む、第二のパラメータに表現すること
        double current = calculateSavings(base, year - 1) * (1 + INTEREST_RATE);
        // 結果を表すこと。
        System.out.println(year + "年目の貯金合計は" + current + "円です");
        // 結果を返すこと、預金を忘れずに
        return current + base;
    }
}
