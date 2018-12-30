package design_pattern.adapter_pattern;

//二项转三相的适配器 对象适配器
public class GBTwoPluginAdapter implements ThreePluginInterface{

    private GBTwoPluginInterface gbTwoPluginInterface;

    public GBTwoPluginAdapter(GBTwoPluginInterface gbTwoPluginInterface){
        this.gbTwoPluginInterface = gbTwoPluginInterface;
    }

    @Override
    public void powerWidthThreePlugin() {
        System.out.println("二相转三相");
        this.gbTwoPluginInterface.powerWidthTwoPlugin();
    }
}
