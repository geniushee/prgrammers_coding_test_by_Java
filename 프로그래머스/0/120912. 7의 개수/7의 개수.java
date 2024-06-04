class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String s = "";
        for(int i : array){
            s = s + i;
        }
        for(char c : s.toCharArray()){
            if(c == '7'){
                answer++;
            }
        }
        return answer;
    }
}