package design_pattern.factory_pattern.factory_function;

public class RightHair implements HairInterface {
    @Override
    public void draw() {
        System.out.println("右偏分发型");
    }
}
