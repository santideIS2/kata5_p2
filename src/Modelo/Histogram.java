package Modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram <T>{
    private final Map<T, Integer> map = new HashMap<>(); 

    public Integer get(T key){
        return map.get(key);
    }

    public Set<T> keySet(){
        return map.keySet();
    }

    public void incremet(T key){
        int value = map.containsKey(key) ? map.get(key) + 1 : 1;
        map.put(key, value);
    }   

}