import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] arr = my_string.split("");
        Set<String> s = new LinkedHashSet<>();
        for(int i = 0; i < arr.length; i++){
            s.add(arr[i]);
        }
        Iterator<String> it = s.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next());
        }
        
        return sb.toString();
    }
}