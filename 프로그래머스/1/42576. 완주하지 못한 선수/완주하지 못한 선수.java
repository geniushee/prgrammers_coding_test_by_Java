import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> part = new HashMap<>();
        for(String c : completion){
            if(part.containsKey(c)){
                part.put(c, part.get(c) + 1);
            } else{
                part.put(c, 1);
            }
        }
        for(String p : participant){
            int temp;
            if(part.containsKey(p)){
                temp = part.get(p);
                if(temp <= 0){
                    return p;
                }
                part.put(p, part.get(p) - 1);
            } else{
                return p;
            }
        }
        return null;
}
}