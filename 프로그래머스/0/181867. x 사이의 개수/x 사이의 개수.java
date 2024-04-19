import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        String[] spl = myString.split("x");
        String[] temp = {};
        if(myString.charAt(myString.length() - 1) == 'x'){
            temp = new String[spl.length + 1];
            for(int i = 0; i < temp.length - 1; i++){
                temp[i] = spl[i];
            }
            temp[temp.length -1] = "";
        } else {
            temp = spl;
        }

        answer = 
            Arrays.stream(temp).mapToInt(str -> str.length()).toArray();
        return answer;
    }
}