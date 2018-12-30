package design_pattern.adapter_pattern;

public class NoteBook {

    private ThreePluginInterface threePluginInterface;


    public NoteBook(ThreePluginInterface threePluginInterface){
        this.threePluginInterface = threePluginInterface;
    }

    public void charge(){
        threePluginInterface.powerWidthThreePlugin();
    }
}
