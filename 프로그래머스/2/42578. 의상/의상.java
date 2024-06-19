import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = Arrays.stream(clothes).collect(Collectors.groupingBy(
        s-> s[1], Collectors.mapping(s -> s[0], Collectors.toList())));
        
        for(List list : map.values()){
            answer*=(list.size() + 1);
        }
        
        return answer -1 ;
    }    
}