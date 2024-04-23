class Solution {
    public int[] solution(int[] arr) {
        int exp = 0;
        while(arr.length > (int) Math.pow(2,exp)){
            exp++;
        }
        
        int pow = (int) Math.pow(2,exp);
        
        int[] answer = new int[pow];
        
        int i = 0; 
        while(i < answer.length){
            if(i < arr.length){
                answer[i] = arr[i];
            } else{
                answer[i] = 0;
            }
            i++;
        }
        
        return answer;
    }
}