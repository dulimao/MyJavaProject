package design_pattern.factory_pattern.factory_function;

public class LeftHair implements HairInterface {
    @Override
    public void draw() {
        System.out.println("做偏分发型");
    }
}
