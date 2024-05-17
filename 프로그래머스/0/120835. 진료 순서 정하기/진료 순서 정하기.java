import java.util.*;
import java.util.Collections;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Integer[] reverse = new Integer[emergency.length];
        for(int r = 0; r < reverse.length; r++){
            reverse[r] = emergency[r];
        }
        Arrays.sort(reverse, Collections.reverseOrder());
        
        for(int i = 0;i< reverse.length; i++){
            int num = reverse[i];
            for(int j = 0; j < emergency.length; j++){
                if(num == emergency[j]){
                    answer[j] = i + 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}