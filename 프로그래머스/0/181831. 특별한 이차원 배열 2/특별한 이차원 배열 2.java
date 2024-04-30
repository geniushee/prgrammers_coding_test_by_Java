import java.util.*;
class Solution {
    public int solution(int[][] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                // System.out.println(Arrays.toString(arr[i]));
                // System.out.println(Arrays.toString(arr[j]));
                if(arr[i][j] != arr[j][i]){
                    return 0;
                }
            }
        }
        return 1;
    }
}