package enshu7;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "ペンギン";
    }

    @Override
    public String getFly() {
        return "飛ばない";
    }
}
