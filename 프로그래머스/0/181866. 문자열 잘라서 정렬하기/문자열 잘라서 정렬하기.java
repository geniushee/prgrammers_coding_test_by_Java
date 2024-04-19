import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = {};
        String[] temp = myString.split("x");
        temp = Arrays.stream(temp).map(String::trim).filter(str -> !str.equals("")).toArray(String[]::new);
        Arrays.sort(temp);
        return temp;
    }
}