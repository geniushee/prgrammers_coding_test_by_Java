import java.util.stream.*;
import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = my_string.trim().split(" ");
        answer = Arrays.stream(answer).filter(str -> !str.equals("")).toArray(String[]::new);
        return answer;
    }
}