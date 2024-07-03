class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            answer[i] = check(i,prices);
        }
        return answer;
    }
    public int check(int idx, int[] arr){
        int a = arr[idx];
        int val = 0;
        for(int i = idx +1; i < arr.length; i++){
            val++;
            if(a <= arr[i]){
                continue;
            }else{
                return val;
            }
        }
        return val;
    }
}