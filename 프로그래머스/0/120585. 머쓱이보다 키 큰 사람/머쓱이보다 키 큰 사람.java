import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        Arrays.sort(array);
        int answer = 0;
        int c = 0;
        
        for(int i : array){
            if(i <= height){
                c++;
            } else{
                break;
            }
        }
        
        return array.length - c;
    }
}