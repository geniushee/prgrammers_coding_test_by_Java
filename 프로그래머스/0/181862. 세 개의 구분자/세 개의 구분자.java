import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        String[] emp = {"EMPTY"};
        String[] com = {"a","b","c"};
        for(String a : com){
            myStr = myStr.replace(a,"0");
        }
        answer = Arrays.stream(myStr.split("0")).filter(str -> !str.equals("")).toArray(String[]::new);
        return answer.length == 0 ? emp : answer;
    }
}