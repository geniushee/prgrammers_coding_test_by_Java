import java.lang.Math;

class Solution {
    public int solution(int n) {
        int a =(int) Math.sqrt((double) n);
        if(a * a == n){
            return 1;
        }else {
            return 2;
        }
    }
}