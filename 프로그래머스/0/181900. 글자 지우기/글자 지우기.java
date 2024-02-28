import java.util.Arrays;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = my_string;
        Arrays.sort(indices);
        for(int i = indices.length - 1; i >= 0;i--){
            int j = indices[i];
            answer = answer.substring(0,j) + answer.substring(j+1);
        }
        return answer;
    }
}