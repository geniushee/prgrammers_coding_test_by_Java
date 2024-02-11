class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int idx = 0;
        for (boolean b : included){
            if (b){
                answer = answer + a + d * idx;
            }
            idx++;
        }
        return answer;
    }
}