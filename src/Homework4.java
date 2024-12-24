/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * 初の宿題：ランダム表現プログラム
 * 学生証番号：24z1e146
 */

public class Homework4 {
    // 定数 N の定義、最大反復回数（1e6 は 100万を表す）
    public static final int N = (int) 1e6;

    // コイントスの結果を格納する配列、インデックスは0から10までの「表」が出た回数を表す
    public static int[] statusStore = new int[11];

    // コイントスを行うメソッド、結果が「表」か「裏」かをランダムに判定する
    public static boolean omote() {
        // Math.random() でランダムな小数値を生成（0.0以上1.0未満）
        double coin_status = Math.random();
        // 0.5未満なら「表」を返し、0.5以上なら「裏」を返す
        return coin_status < 0.50f;
    }

    public static void main(String[] args) {
        // 全体の反復回数を管理する変数
        int interateCount = 1;
        // 最大反復回数 N 回まで繰り返し
        while (interateCount++ <= N) {
            // 10回コイントスして「表」が出た回数をカウント
            int trueCount = 0;
            for (int i = 0; i < 10; i++) {
                // 1回のコイントスの結果を取得
                boolean resultForOneIterate = omote();
                // 結果が「表」の場合カウントを増やす
                if (resultForOneIterate) {
                    trueCount++;
                }
            }
            // 「表」が出た回数を配列に記録
            statusStore[trueCount]++;
        }

        // 0〜10回「表」が出た回数を表示
        for (int i = 0; i < statusStore.length; i++) {
            System.out.printf("%2d: %d\n", i, statusStore[i]);
        }
    }
}
