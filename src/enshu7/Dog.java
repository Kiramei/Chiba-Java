package enshu7;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "イヌ";
    }

}
