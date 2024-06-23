import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(list.size() == 0){
                list.add(i);
            }
            else if(list.get(list.size() - 1) == i){
                continue;
            }else{
                list.add(i);
            }
        }

        answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}