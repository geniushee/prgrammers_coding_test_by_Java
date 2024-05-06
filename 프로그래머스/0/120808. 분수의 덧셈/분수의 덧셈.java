import java.util.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int denom = minint(denom1, denom2);
        int numer = numer1 * (denom / denom1) + numer2 * (denom / denom2);
        int max = maxint(numer, denom);
        
        if (max != 1){
            denom = denom / max;
            numer = numer / max;
        }
        answer[0] = numer;
        answer[1] = denom;
        return answer;
    }
    
    public int minint(int num1, int num2){
        int max = maxint(num1, num2);
        System.out.println(max);
        return num1 * num2 / max;
    }
    
    public int maxint(int num1, int num2){
        int i = 2;
        int maxint = 1;
        while( i <= num1 || i <= num2){
            if(num1 % i == 0 && num2 % i == 0){
                maxint = i;
            }
            i++;
        }
        return maxint;
    }
}