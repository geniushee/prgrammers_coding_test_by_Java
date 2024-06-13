import java.lang.*;
class Solution {
    public int solution(int[] common) {
        int answer = 0;
        if(common[1] - common[0] == common[2] - common[1]){
            int d = common[1] - common[0];
            return common[0] + d * common.length;
        }
            int r = common[1] / common[0];
            return common[0] *(int) Math.pow(r, common.length);
    }
}