class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int count = 0;
        for(boolean b : finished){
            if(!b){count++;}
        }
        String[] answer = new String[count];
        int j = 0;
        for(int i = 0; i < finished.length; i++){
            if(!finished[i]){
                answer[j] = todo_list[i];
                j++;
            }
        }
        return answer;
    }
}