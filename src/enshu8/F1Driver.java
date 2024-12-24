/**
 * @author リク　セイケツ  「陸成傑」   「LU CHENGJIE」
 * プロジェクト: enshu8, パッケージ: enshu8, クラス: F1Driver
 * 学校番号：24z1e146
 */
package enshu8;

public class F1Driver {
    public F1Driver(int carNum, String name, String cons, String nationality, int birth, int point) {
        this.carNum = carNum;
        this.name = name;
        this.cons = cons;
        this.nationality = nationality;
        this.birth = birth;
        this.point = point;
    }

    private int carNum;
    private String name;
    private String cons;
    private String nationality;
    private int birth;
    private int point;

    void printDriver() {
        // オブジェクトのデータを整形して画面表示するメソッド
        System.out.printf("%2d %-20s %-15s %-20s %4d %3d\n", carNum, name, cons, nationality, birth, point);
    }

    public void search(int key) {
        // ここを記述する
        // carNum, birth, point のそれぞれと key の値を比較して
        // key と等しかったら printDriver() を実行する
        if (carNum == key || birth == key || point == key) {
            printDriver();
        }
    }

    public void search(String key) {
        // ここを記述する
        // name, cons, nationality に文字列 key が含まれていたら
        // printDriver() を実行する
        // 文字列に対して、メソッド indexOf(検索文字列) を実行すると、
        // その文字列内で検索文字列が最初に出現する添字を返す。
        // 文字列が含まれない場合は -1 を返す
        // name.indexOf(key) のように使用する
        if (name.indexOf(key) != -1 || cons.indexOf(key) != -1 || nationality.indexOf(key) != -1) {
            printDriver();
        }
        // これも同じ効果です
        // if (name.contains(key) || cons.contains(key) || nationality.contains(key)) {
        //    printDriver();
        // }
    }
}