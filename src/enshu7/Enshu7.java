
//プロジェクト: enshu7, パッケージ: enshu7, クラス:Enshu7
//演習ではこのメソッドは書き変えないこと
package enshu7;



public class Enshu7 {
    public static void main(String[] args) {
        Hito luffy = new Hito("ルフィ");
        Penguin pingu = new Penguin("Pingu");
        Dog jiro = new Dog("次郎");
        Canaria tweety = new Canaria("Tweety");
        System.out.println(luffy.getName() + "は" + luffy.getType() +
                "なので足の数は" + luffy.getAshi() + "本で" + luffy.getFly());
        System.out.println(pingu.getName() + "は" + pingu.getType() +
                "なので足の数は" + pingu.getAshi() + "本で" + pingu.getFly());
        System.out.println(jiro.getName() + "は" + jiro.getType() +
                "なので足の数は" + jiro.getAshi() + "本で" + jiro.getFly());
        System.out.println(tweety.getName() + "は" + tweety.getType() +
                "なので足の数は" + tweety.getAshi() + "本で" + tweety.getFly());
    }
}