//プロジェクト: enshu8, パッケージ: enshu8, クラス: Enshu8
//このファイルは一切変更しないこと
package enshu8;
public class Enshu8 {
    public static void main(String[] args) {
        F1Driver[] drv = new F1Driver[10];
        drv[0] = new F1Driver(1,"Max Verstappen","Red Bull Racing","Netherlands",1997,393);
        drv[1] = new F1Driver(11,"Sergio Perez","Red Bull Racing","Mexico",1990,151);
        drv[2] = new F1Driver(44,"Lewis Hamilton","Mercedes","United Kingdom",1985,190);
        drv[3] = new F1Driver(77,"George Russell","Mercedes","United Kingdom",1998,192);
        drv[4] = new F1Driver(16,"Charles Leclerc","Ferrari","Monaco",1997,307);
        drv[5] = new F1Driver(55,"Carlos Sainz","Ferrari","Spain",1994,244);
        drv[6] = new F1Driver(4,"Lando Norris","McLaren","United Kingdom",1999,331);
        drv[7] = new F1Driver(81,"Oscar Piastri","McLaren","Australia",2001,262);
        drv[8] = new F1Driver(14,"Fernando Alonso","Aston Martin","Spain",1981,62);
        drv[9] = new F1Driver(18,"Lance Stroll","Aston Martin","Canada",1998,24);
        System.out.println("ドライバーのリスト");
        for (int i = 0; i < drv.length; i++) {
            drv[i].printDriver();
        }
        System.out.println();
        System.out.println("数字1997の検索結果");
        for (int i = 0; i < drv.length; i++) {
            drv[i].search(1997);
        }
        System.out.println();
        System.out.println("文字列\"in\"の検索結果");
        for (int i = 0; i < drv.length; i++) {
            drv[i].search("in");
        }
        System.out.println();
    }
}