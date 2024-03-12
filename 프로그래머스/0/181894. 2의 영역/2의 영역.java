class Solution {
    public int[] solution(int[] arr) {
        
        int len = arr.length;
        int a = index(arr, 2);  // 1
        int b = reverseIndex(arr, 2); // -2
        if(a == -1) return new int[]{-1};
        
        int length = len + b - a + 1;
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            answer[i] = arr[i+a];
        }
        
        return answer;
    }
    
    public int index(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num) return i;
        }
        return -1;
    }
    
    public int reverseIndex(int[] arr, int num){
        int len = arr.length;
        for(int i = 1; len - i >= 0; i++){
            if(arr[len - i] == num) return -i;
        }
        return 0;
    }
}