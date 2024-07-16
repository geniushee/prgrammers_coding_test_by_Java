import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] hidx = new Integer[citations.length];
        
        for(int i = 0; i < citations.length; i++){
            hidx[i] = citations[i];
        }
        
        Arrays.sort(hidx, Comparator.reverseOrder());
        
        int pointer = 0;
        int max = 0;
        while(hidx[pointer] >= pointer + 1){
            max = ++pointer;
            if(pointer >= hidx.length){
                break;
            }
        }
        
        
        return max;
    }
}