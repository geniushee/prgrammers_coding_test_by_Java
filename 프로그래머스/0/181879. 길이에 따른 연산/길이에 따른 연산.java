class Solution {
    public int solution(int[] num_list) {
        boolean tenOver = num_list.length >= 11 ? true : false;
        int answer = 0;
        if(tenOver){
            for(int num : num_list){
                answer += num;
            }
        } else{
            answer = 1;
            for(int num: num_list){
                answer = answer * num;
            }
        }
        
        return answer;
    }
}