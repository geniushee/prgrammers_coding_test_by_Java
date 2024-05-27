import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        for(int i=0;i<sides.length;i++){
        System.out.println(sides[i]);}
        if(sides[2] < sides[0] + sides[1]){
            return 1;
        }else{
            return 2;
        }
        
    }
}