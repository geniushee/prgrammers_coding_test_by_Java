import java.lang.String;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        int i = 0;
        while (i < str_list.length){
            if(str_list[i].equals("l")){
                answer = new String[i];
                for(int j = 0; j < i; j++){
                    answer[j] = str_list[j];
                }
                return answer;
            } else if(str_list[i].equals("r")){
                answer = new String[str_list.length - i - 1];
                for(int j = 0; j + i + 1< str_list.length; j++){
                    answer[j] = str_list[j + i + 1];
                }
                return answer;
            }
            i++;
        }
        return answer;
    }
}