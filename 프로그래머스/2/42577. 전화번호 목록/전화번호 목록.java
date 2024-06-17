import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 1; i < phone_book.length; i++){
            String a = phone_book[i-1];
            String b = phone_book[i];
            if(b.startsWith(a)){
                return false;
            }
        }
        return answer;
    }
}