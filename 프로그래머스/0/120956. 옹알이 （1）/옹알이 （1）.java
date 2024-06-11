class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] chg = {"aya", "ye", "woo", "ma"};
        
            for(int i =0;i<babbling.length;i++){
                for(String s : chg){
                babbling[i] = babbling[i].replace(s," ");
            }
        }
        for(String b : babbling){
            // System.out.println(b);
            if(b.isBlank()){
                // System.out.println("카운트");
                answer++;
            }
        }
        return answer;
    }
}