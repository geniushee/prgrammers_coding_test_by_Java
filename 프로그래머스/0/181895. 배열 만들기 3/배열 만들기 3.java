class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int a = intervals[0][0];
        int b = intervals[0][1];
        int c = intervals[1][0];
        int d = intervals[1][1];
        
        int len = b - a + 1 + d - c + 1;
        int[] answer = new int[len];
        
        for(int i = 0;i< b - a + 1;i++){
            answer[i] = arr[a+i];
        }
        for(int i = 0;i < d - c + 1; i++){
            answer[b - a + 1 + i] = arr[c+i];
        }
        
        return answer;
    }
}