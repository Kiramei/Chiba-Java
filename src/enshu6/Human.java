/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * 宿題：BMIの計算，オブジェクト指向プログラミング
 * 学生証番号：24z1e146
 */
package enshu6;

public class Human {
    /**
     * Field name, height, weight
     * name: 名前
     * height: 身長
     * weight: 体重
     */
    public String name;
    public double height;
    public double weight;

    /**
     * BMIを計算し、肥満度を判定する
     */
    public void printHimando() {
        String message;
        double bmi;

        // 名前、身長、体重がnullまたは0以下の場合、エラーメッセージを出力する
        assert name != null : "名前は付けてください！";
        assert height > 0 : "身長は正の値である必要があります！";
        assert weight > 0 : "体重は正の値である必要があります！";

        // BMIを計算する
        bmi = weight / (height / 100 * height / 100);

        // 肥満度を判定する
        if (bmi < 18.5) {
            message = "やせ"; // BMIが18.5未満の場合、やせと判定
        } else if (bmi < 25.0) {
            message = "普通"; // BMIが18.5以上25.0未満の場合、普通と判定
        } else if (bmi < 30.0) {
            message = "肥満1度"; // BMIが25.0以上30.0未満の場合、肥満1度と判定
        } else if (bmi < 35.0) {
            message = "肥満2度"; // BMIが30.0以上35.0未満の場合、肥満2度と判定
        } else if (bmi < 40.0) {
            message = "肥満3度"; // BMIが35.0以上40.0未満の場合、肥満3度と判定
        } else {
            message = "肥満4度"; // BMIが40.0以上の場合、肥満4度と判定
        }

        // 結果を出力する
        System.out.printf("%sのBMIは%4.1fで肥満度は「%s」です\n", name, bmi, message);
    }
}

/*
 * この方法が足りない点：
 * １．Humanクラスのフィールドにprivate修飾子を付けること。フィールドは外部から直接アクセスされないようにすること
 * ２．Humanクラスのフィールドにfinal修飾子を付けること。フィールドは一度代入されたら変更されないようにすること
 * ３．Humanクラスのフィールドに初期値を設定すること。フィールドは初期値を持つようにすること
 * ４．コンストラクタが不足していること。Humanクラスにコンストラクタを追加すること
 */