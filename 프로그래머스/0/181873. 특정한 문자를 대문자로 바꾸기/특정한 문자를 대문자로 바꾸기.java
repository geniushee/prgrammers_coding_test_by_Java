import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, String alp) {
        List<String> list = Arrays.asList(my_string.split(""));
        String answer = list.stream().map(str -> {
            if(str.equals(alp)){
                str = str.toUpperCase();
            }
            return str;
        }).collect(Collectors.joining());
        return answer;
    }
}