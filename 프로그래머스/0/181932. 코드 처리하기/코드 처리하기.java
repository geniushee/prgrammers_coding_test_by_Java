class Solution {
    public String solution(String code) {
        String answer = "";
        int idx = 0;
        int mode = 0;
        while (idx < code.length()){
            String c = code.substring(idx,idx+1);
            switch (mode){
                case 0: 
                    if (c.equals("1")){
                    mode = 1; break;
                    }
                    if (idx % 2 == 0){
                        answer += c;}
                    break;
                case 1:
                    if (c.equals("1")){
                    mode = 0; break;
                    }
                    if (idx % 2 == 1){
                        answer += c;}
                    break;
            }
            idx++;
        }
        if (answer.equals("")){
            return "EMPTY";
        }
        return answer;
    }
}