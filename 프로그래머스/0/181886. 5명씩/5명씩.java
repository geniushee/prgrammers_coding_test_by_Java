class Solution {
    public String[] solution(String[] names) {
        int mod = names.length / 5;
        if(names.length % 5 > 0) mod = mod + 1;
        String[] answer = new String[mod];
        for(int i =0 ; i < mod; i++){
            answer[i] = names[i*5];
        }
        return answer;
    }
}