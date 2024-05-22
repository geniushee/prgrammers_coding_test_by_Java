class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 4; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= i; j++){
                
                if(i % j == 0){
                    count++;
                }
                // System.out.println("c: "+count+"\n i,j : " + i + ", " + j);
                if(count >= 3){
                    answer++;
                    break;
                }
            }
            // System.out.println(answer);
        }
        return answer;
    }
}