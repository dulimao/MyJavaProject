package design_pattern.factory_pattern.factory_function;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HairFactory {
    public HairInterface getHair(String className){
        try {
            HairInterface hairInterface = (HairInterface) Class.forName(className).newInstance();
            return hairInterface;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HairInterface getHairByKey(String key){
        try {
            Map<String,String> map = readFile();
            HairInterface hairInterface = (HairInterface) Class.forName(map.get(key)).newInstance();
            return hairInterface;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Map<String,String> readFile(){
        Properties properties = new Properties();
        HashMap<String,String> map = new HashMap<>();
        InputStream inputStream = getClass().getResourceAsStream("type.properties");
        try {
            properties.load(inputStream);
            Enumeration en = properties.propertyNames();
            while (en.hasMoreElements()){
                String key = (String) en.nextElement();
                String value = properties.getProperty(key);
                map.put(key,value);
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
