class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        int mo = code.length() / q;
        int mod = code.length() % q;
        for(int i = 0; i < mo; i++){
            String temp = code.substring(0 + q * i).substring(r,r+1);
            answer += temp;
        }
        if(mod != 0 && r < mod){
            answer = answer + code.substring(q * mo).substring(r, r + 1);
        }
        return answer;
    }
}