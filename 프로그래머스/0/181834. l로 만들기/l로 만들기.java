class Solution {
    public String solution(String myString) {
        char i = 'l';
        int filter = i;
        String answer = "";
        
        for(char c : myString.toCharArray()){
            int temp = c;
            if(temp < filter){
                c = i;
            }
            answer += String.valueOf(c);
        }
        return answer;
    }
}