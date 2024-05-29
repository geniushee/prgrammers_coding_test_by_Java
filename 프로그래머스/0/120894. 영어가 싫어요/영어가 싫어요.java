import java.util.*;

class Solution {
    public long solution(String numbers) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");        
        
        char[] arr = numbers.toCharArray();
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for(char c : arr){
            sb.append(c);
            String current = map.get(sb.toString());
            if(current != null){
                ans.append(current);
                sb.setLength(0);
            }
        }
        
        return Long.valueOf(ans.toString());
    }
}