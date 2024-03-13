class Solution {
    public int[] solution(int[] arr, int[] query) {
        for(int i = 0;i < query.length; i++){
            switch(i%2){
                case 0: arr = even(arr,query[i]); break;
                case 1: arr = odd(arr,query[i]); break;
            }
        }
        
        return arr;
    }
    
    public int[] odd(int[] arr, int idx){
        int len = arr.length;
        int[] temp = new int[len - idx];
        for(int i=0;i<len - idx;i++){
            temp[i] = arr[i + idx];
        }
        return temp;
    }
    
    public int[] even(int[] arr, int idx){
        int[] temp = new int[idx + 1];
        for(int i=0;i<idx+1;i++){
            temp[i] = arr[i];
        }
        return temp;
    }
    
}