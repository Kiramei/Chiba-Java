//プロジェクト: java11_6, パッケージ: java11_6, クラス: F1Driver
package java11_6;

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
        System.out.printf("%2d %-18s %-17s %-18s %4d %3d\n", carNum, name, cons, nationality, birth, point);
    }

    String outputString() {
// オブジェクトのデータをcsv形式の文字列として出力するメソッド
        return carNum + "," + name + "," + cons + "," + nationality + "," + birth + "," + point + "\n";
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}