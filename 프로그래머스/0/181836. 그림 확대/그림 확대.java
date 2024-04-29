class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int idx = 0;
        for(String row : picture){
            for(int i = 0; i < k; i++){
                answer[idx] = muti(row, k);
                idx++;
            }
        }
        return answer;
    }
    
    public String muti(String str, int mn){
        String answer = "";
        for(String s : str.split("")){
            for(int i =0; i < mn; i++){
                answer += s;
                // System.out.println(answer);
            }
        }
        return answer;
    }
}