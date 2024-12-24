package enshu7;

public class Hito extends Animal {

    public Hito(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "ヒト";
    }

    @Override
    public int getAshi() {
        return 2;
    }
}
