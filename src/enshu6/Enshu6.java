package enshu6;

public class Enshu6 {
    public static void main(String[] args) {
        Human taro = new Human();
        Human jiro = new Human();
        taro.name = "太郎";
        taro.height = 170.0;
        taro.weight = 53.0;
        jiro.name = "次郎";
        jiro.height = 171.0;
        jiro.weight = 78.0;
        taro.printHimando();
        jiro.printHimando();
    }
}