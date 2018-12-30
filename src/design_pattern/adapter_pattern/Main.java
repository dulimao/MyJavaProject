package design_pattern.adapter_pattern;

/**
 * 适配器模式--解决不兼容问题
 */
public class Main {

    public static void main(String[] args){
        //使用组合方式实现电源插座适配
//        GBTwoPluginInterface gbTwoPluginInterface = new GBTwoPluginInterface();
//        ThreePluginInterface threePluginInterface = new GBTwoPluginAdapter(gbTwoPluginInterface);
//        NoteBook noteBook = new NoteBook(threePluginInterface);
//        noteBook.charge();【


        ThreePluginInterface threePluginInterface = new GBTwoPluginAdpterByExtends();
        NoteBook noteBook = new NoteBook(threePluginInterface);
        noteBook.charge();

    }
}
