import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int i = sides[0] + sides[1] - 1; //max
        while(true){
            if(i >= sides[1]){
                answer++;
            } else if(sides[1] < i + sides[0]){
                answer++;
            }else{
                break;
            }
            i--;
        }
            
        return answer;
    }
}