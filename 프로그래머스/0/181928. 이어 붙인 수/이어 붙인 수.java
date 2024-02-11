import java.lang.Integer.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";
        for (int n : num_list){
            if (n % 2 == 1){
                odd += n;
            } else{
                even += n;
            }
        }
        answer = Integer.parseInt(odd) + Integer.parseInt(even);
        return answer;
    }
}