import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<String, Integer> map1 = createMap(before);
        Map<String, Integer> map2 = createMap(after);
        
        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            String k = entry.getKey();
            Integer val = entry.getValue();
            if(map1.get(k) == null){
                return 0;
            }else if(!map1.get(k).equals(val)){
                return 0;
            }
        }
        return 1;
    }
    public Map<String, Integer> createMap(String str){
    Map<String, Integer> map = new HashMap<>();
        for(String k : str.split("")){
            if(map.containsKey(k)){
                int val = map.get(k) + 1;
                map.put(k,val);
            }else {
                map.put(k,1);
            }
        }
        return map;
    }
}