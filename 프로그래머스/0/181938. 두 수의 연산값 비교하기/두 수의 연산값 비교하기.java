class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int aint = Integer.parseInt(""+a+b);
        answer = aint > 2 * a * b ? aint : 2 * a *b;
        
        return answer;
    }
}