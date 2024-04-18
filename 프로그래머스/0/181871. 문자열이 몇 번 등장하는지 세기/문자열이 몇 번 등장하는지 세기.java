class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int len = pat.length();
        int idx = 0;
        while(idx + len <= myString.length()){
            String bit = myString.substring(idx, idx + len);
            
            if(bit.equals(pat)){
                answer++;
            }
            idx++;
        }
        return answer;
    }
}