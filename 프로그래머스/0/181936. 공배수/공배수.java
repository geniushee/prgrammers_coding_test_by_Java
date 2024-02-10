class Solution {
    public int solution(int num, int n, int m) {
        int answer = 0;
        int mod1 = num % n;
        int mod2 = num % m;
        
        if (mod1 == 0 && mod2 == 0){
            return 1;
        }
        return answer;
    }
}