class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int mo = my_string.length() / m;
        int mod = my_string.length() % m;
        for(int i = 0; i < mo; i++){
            String temp = my_string.substring(0 + m * i);
            answer = answer + temp.substring(c-1,c);
        }
        if(mod != 0 && c < mod){
            answer = answer + my_string.substring(m * mo).substring(c-1,c);
        }
        return answer;
    }
}