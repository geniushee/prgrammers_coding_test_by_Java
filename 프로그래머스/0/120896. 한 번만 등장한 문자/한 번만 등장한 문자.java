import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        Arrays.sort(arr);
        Map<String, Integer> map = new HashMap<>();

        for(String a : arr){
           map.put(a, map.getOrDefault(a,0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }

        return sb.toString();
    }
}