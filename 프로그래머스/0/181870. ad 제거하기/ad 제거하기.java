import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = Arrays.stream(strArr).map(str -> str.replace("ad", "0"))
            .filter(str -> str.indexOf("0") == -1)
            .toArray(String[]::new);
        return answer;
    }
}