class Solution {
    public int[] solution(int[] arr, int n) {
        int len = arr.length;
        int i;
        if(len % 2 == 1){
            i = 0;
        }else{
            i = 1;
        }
        
        while(i < arr.length){
            arr[i] += n;
            i += 2;
        }
        
        return arr;
    }
}