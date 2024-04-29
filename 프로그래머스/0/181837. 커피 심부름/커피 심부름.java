class Solution {
    public int solution(String[] order) {
        int answer = 0;
        int[] orders = new int[2];
        for(String o : order){
            if(o.contains("americano") || o.contains("anything")){
                orders[0] += 1;
            } else {
                orders[1] += 1;
            }
        }
        answer = orders[0] * 4500 + orders[1] * 5000;
        return answer;
    }
}