class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        // yellow = (n-2) * (m-2);
        int row = 0;
        int col = 0;
        
        for(int i = 3; i <= total / 3; i++){
            int t = 0;
            if(total % i == 0){
                row = i;
                col = total / i;
                t = (row -2) * (col -2);
                if(yellow == t){
                    break;
                }
                row = 0;
                col = 0;
            }
        }
        
        if(row >= col){
            answer[0] = row;
            answer[1] = col;
        }else{
            answer[0] = col;
            answer[1] = row;
        }
        return answer;
    }
}