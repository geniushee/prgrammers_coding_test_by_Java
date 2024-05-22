class Solution {
    public int solution(int n) {
        int p = 1;
        for(int i = 1; i <= 10; i++){
            p *=i;
            if(p > n){
                return i -1;
            }
        }
        return 10;
    }
}