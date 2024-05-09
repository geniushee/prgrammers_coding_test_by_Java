class Solution {
    public int solution(int n) {
        int answer = 0;
        int whole = n / 7;
        int piece = n % 7;
        if (piece > 0){
            whole++;
        }
        return whole;
    }
}