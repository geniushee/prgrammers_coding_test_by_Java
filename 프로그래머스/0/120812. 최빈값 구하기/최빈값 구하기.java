import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Map<Integer, Integer> intmap = new HashMap<>();
        
        for(int i : array){
            if(intmap.get(i) == null){
                intmap.put(i, 1);
            } else {
                int val = intmap.get(i) + 1;
                intmap.put(i, val);
            }
        }
        
        int maxcount = 0;
        
        for(Map.Entry<Integer, Integer> entry : intmap.entrySet()){
            
            if(maxcount < entry.getValue()){
                answer = entry.getKey();
                maxcount = entry.getValue();
            } else if(maxcount == entry.getValue()){
                answer = -1;
            }
            // System.out.println(entry.getKey() + "/" + entry.getValue() + " / max : " + maxcount);
        }
        
        return answer;
    }
}