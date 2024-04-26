import java.util.*; import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] del) {
        for(int i = 0; i < del.length; i++){
            int filter = del[i];
        arr  = Arrays.stream(arr).filter(num -> filter != num).toArray();
        }
        
        return arr;
    }
}