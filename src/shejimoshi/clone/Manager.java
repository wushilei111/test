package shejimoshi.clone;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private static Map<String,A> map = new HashMap<String,A>();
    private Manager(){}
    public static void addA(String key,A a){
        map.put(key,a);
    }

    public static A getA(String key )throws Exception{
        if(map.containsKey(key))
            return map.get(key);
        throw new Exception("没有此对象");
    }

    public void removeA(String key){
        map.remove(key);
    }
}
