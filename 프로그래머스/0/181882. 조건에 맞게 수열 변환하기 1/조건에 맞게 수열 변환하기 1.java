class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int t = arr[i];
            if(t >= 50 && t % 2 == 0){
                answer[i] = t / 2;
            }
            else if(t < 50 && t % 2 == 1){
                answer[i] = t *2;
            } else{
                answer[i] = t;
            }
        }
        return answer;
    }
}