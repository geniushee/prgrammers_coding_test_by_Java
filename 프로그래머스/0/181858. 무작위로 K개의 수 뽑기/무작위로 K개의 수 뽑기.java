import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(list.indexOf(i) == -1){
                list.add(i);
            }
            if(list.size() >= k){
                break;
            }
        }
        while(list.size() < k){
            list.add(-1);
        }
        answer = list.stream().mapToInt(j -> j).toArray();
        return answer;
    }
}