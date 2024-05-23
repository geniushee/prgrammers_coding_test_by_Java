import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        // '0' == 48
        List<Integer> answer = new ArrayList<>();
        char[] arr = my_string.toCharArray();
        for(char c : arr){
            if(c >= 48){
                if(c <=57){
                    answer.add(Integer.valueOf(c - 48));
                }
            }
        }
        int[] res = answer.stream().mapToInt(i -> i).toArray();
        Arrays.sort(res);
        return res;
    }
}