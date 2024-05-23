class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[A-Z|a-z]","");
        for(char c : my_string.toCharArray()){
            answer += (c -48);
        }
        return answer;
    }
}