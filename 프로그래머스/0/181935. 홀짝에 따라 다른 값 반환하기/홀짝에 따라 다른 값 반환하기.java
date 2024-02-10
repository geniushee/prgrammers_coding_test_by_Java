class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n % 2 == 1){
            return odd(n);
        }
        return even(n);
    }
    
    public int odd(int n){
        int result = 0;
        for (int i = 1;i <= n; i += 2){
            result += i;
        }
        return result;
    }
    
    public int even(int n){
        int result = 0;
        for (int i = 2; i <= n; i += 2){
            result += i * i;
        }
        return result;
    }
}