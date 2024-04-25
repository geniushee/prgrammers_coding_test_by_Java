class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        if(isOdd(a) && isOdd(b)){
            answer = (int) Math.pow(a,2) + (int) Math.pow(b,2);
        } else if(isOdd(a) || isOdd(b)){
            answer = 2 * (a + b);
        } else{
            if(a > b){
                answer = a - b;
            } else{
                answer = b - a;
            }
        }
        return answer;
    }
    
    public boolean isOdd(int n){
        return n % 2 == 1 ? true : false;
    }
}