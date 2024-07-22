class Solution {
    public int solution(int[][] sizes) {
        int longer = 0;
        int shorter = 0;
        
        for(int[] bit : sizes){
            int bit_long = 0;
            int bit_short = 0;
            
            if(bit[0] >= bit[1]){
                bit_long = bit[0];
                bit_short = bit[1];
            } else {
                bit_long = bit[1];
                bit_short = bit[0];
            }
            
            if(longer < bit_long){
                longer = bit_long;
            }
            if(shorter < bit_short){
                shorter = bit_short;
            }
        }
        
        return shorter * longer;
    }
}