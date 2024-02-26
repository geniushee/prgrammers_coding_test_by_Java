class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String temp = "";
        for(int j = 0;j<=e-s;j++){
            temp = temp + my_string.substring(e-j,e-j+1);
        }
        answer = my_string.substring(0,s) + temp + my_string.substring(e+1);
        return answer;
    }
}