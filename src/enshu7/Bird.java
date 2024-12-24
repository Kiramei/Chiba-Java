package enshu7;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "トリ";
    }

    @Override
    public String getFly() {
        return "飛ぶ";
    }

    @Override
    public int getAshi() {
        return 2;
    }
}
