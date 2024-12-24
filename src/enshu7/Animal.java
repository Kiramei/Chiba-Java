//プロジェクト: enshu7, パッケージ: enshu7, クラス: Animal
//演習ではこのメソッドは書き変えないこと
package enshu7;
public class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public String getName() { // オーバーライド不要
        return name;
    }
    public String getType() { // 必ずオーバーライド
        return "動物";
    }
    public int getAshi() { // 必要に応じてオーバーライド
        return 4;
    }
    public String getFly() {// 必要に応じてオーバーライド
        return "飛ばない";
    }
}