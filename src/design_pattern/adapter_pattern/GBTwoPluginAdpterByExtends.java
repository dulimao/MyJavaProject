package design_pattern.adapter_pattern;

//类适配器
public class GBTwoPluginAdpterByExtends extends GBTwoPluginInterface implements ThreePluginInterface {
    @Override
    public void powerWidthThreePlugin() {
        System.out.println("通过继承方式转换");
        this.powerWidthTwoPlugin();
    }
}
