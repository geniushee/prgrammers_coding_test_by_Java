import java.lang.Integer.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int qIdx = 0; qIdx < queries.length; qIdx++){
            int[] query = queries[qIdx];
            Integer temp = null;
            for (int i = query[0]; i <= query[1]; i++){
                    if (arr[i] > query[2]){
                        if(temp == null) temp = arr[i];
                        else if(temp > arr[i]){
                            temp = arr[i];
                        }
                    }
            }
            
            if(temp == null){
                answer[qIdx] = -1;
            } else{
                answer[qIdx] = temp;
            }
        }
        
        return answer;
    }
}