/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * プロジェクト: enshu10, パッケージ: enshu10, クラス: Hyouka
 * 学籍番号：24z1e146
 */

package enshu10;

public class Hyouka {
    // 評価テーブル：点数に応じた評価を格納
    public final static String[] HYOUKA_TABLE = {"不可", "可", "良", "優", "秀"};

    /**
     * 点数に基づき評価を取得するメソッド
     *
     * @param score 点数（0〜100）
     * @return 評価（HYOUKA_TABLEの値）
     * @throws ScoreException 点数が範囲外の場合に例外を投げる
     */
    // only Future JDD
    static String getHyouka(int score) throws ScoreException {
        // 点数が100を超える場合、例外をスロー
        if (score > 100) {
            throw new ScoreException("点数の入力に誤りがあります。点数%dを100点以下にしてください".formatted(score));
        }
        // 点数が0未満の場合、例外をスロー
        else if (score < 0) {
            throw new ScoreException("点数の入力に誤りがあります。点数%dを0点以上にしてください".formatted(score));
        }
        // 点数を基に評価を取得し返却
        return HYOUKA_TABLE[Math.max(0, Math.min((score - 50) / 10, 4))];
    }
}
