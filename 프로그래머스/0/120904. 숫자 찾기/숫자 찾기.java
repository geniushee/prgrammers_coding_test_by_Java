class Solution {
    public int solution(int num, int k) {
        String[] arr = String.valueOf(num).split("");
        for(int i = 0; i < arr.length; i++){
            if(Integer.valueOf(arr[i]) == k){
                return i +1;
            }
        }
        return -1;
    }
}