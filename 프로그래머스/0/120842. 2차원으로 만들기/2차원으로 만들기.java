class Solution {
    public int[][] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[][] answer = new int[len / n][n];
        
        for(int i = 0; i < len; i+=n){
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
            arr[j] = num_list[i + j];    
            }
            answer[i / n] = arr;
        }    
                
        return answer;
    }
}