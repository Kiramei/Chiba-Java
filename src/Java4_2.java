/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * 第三週の宿題：平均、標準偏差、偏差値の計算
 * 学生証番号：24z1e146
 */

import java.util.Arrays;

public class Java4_2 {
    // 10人の素点を配列で表すこと。処理便利のため、double型を利用すること
    public static final double[] soten = {84.0f, 95.0f, 60.0f, 100.0f, 83.0f, 72.0f, 93.0f, 85.0f, 65.0f, 98.0f};

    public static void main(String[] args) {
        //　平均得点を求めること
        double heikin = Arrays.stream(soten).sum() / soten.length;
        // 標準偏差を求めること。標準偏差(10人全体で一つの値) = √(各値の偏差の二乗の合計 / 人数)
        double std = Math.sqrt(Arrays.stream(soten).map(score -> Math.pow(score - heikin, 2)).sum() / soten.length);
        // 各人の偏差値を求めること。偏差値 = 50 + 10 * (個人の得点 - 平均得点) / 標準偏差
        double[] hensachi = Arrays.stream(soten).map(score -> 50.0 + 10.0 * (score - heikin) / std).toArray();

        // 結果を表すこと
        System.out.printf("平均: %6.3f\n", heikin);
        System.out.printf("標準偏差: %6.3f\n", std);
        for (int i = 0; i < soten.length; i++) {
            System.out.printf("%2d: %6.3f\n", i + 1, hensachi[i]);
        }

        // 以上の書き方と同じコード
        /*
            double heikin = 0.0;
            for (int i = 0; i < soten.length; i++) {
                heikin += soten[i];
            }
            heikin /= soten.length;

            double std = 0.0;
            for (int i = 0; i < soten.length; i++) {
                std += Math.pow(soten[i] - heikin, 2);
            }
            std = Math.sqrt(std / soten.length);

            double[] hensachi = new double[soten.length];
            for (int i = 0; i < soten.length; i++) {
                hensachi[i] = 50.0 + 10.0 * (soten[i] - heikin) / std;
            }

            System.out.printf("平均: %6.3f\n", heikin);
            System.out.printf("標準偏差: %6.3f\n", std);
            for (int i = 0; i < soten.length; i++) {
                System.out.printf("%2d: %6.3f\n", i + 1, hensachi[i]);
            }
        */
    }
}

/**
 * この方法のいい点：
 * 1. 10人の素点を配列で表すこと。処理便利のため、double型を利用すること
 * 2. Stream APIを利用すること。平均、標準偏差、偏差値の計算を簡単にすること
 * 3. 結果を表すこと。printfメソッドを利用するので、結果を見やすくすること
 */