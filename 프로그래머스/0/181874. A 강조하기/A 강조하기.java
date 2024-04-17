import java.util.ArrayList;
import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        String answer = "";
        myString = myString.toLowerCase();
        ArrayList<Character> arr = new ArrayList<>();
        for(char c : myString.toCharArray()){
            if(c == 'a'){
                c = Character.toUpperCase(c);
            }
            arr.add(c);
        }
        answer = arr.stream().map(String::valueOf)
            .collect(Collectors.joining());
        return answer;
    }
}