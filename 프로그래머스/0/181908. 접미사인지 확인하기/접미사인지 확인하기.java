import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        ArrayList<String> list = new ArrayList<>();

        for(int i =0; i < my_string.length();i++){
            list.add(my_string.substring(i));
        }
        
        if (list.indexOf(is_suffix) != -1) return 1;
        else return 0;
    }
}