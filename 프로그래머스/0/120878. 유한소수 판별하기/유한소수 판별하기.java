class Solution {
    public int solution(int a, int b) {
        int[] arr = {2, 5};
        for(int m : arr){
            while(b % m == 0){
                b /= m;
            }
        }
        
        if(a % b == 0){
            return 1;
        }
        
        return 2;
    }
}