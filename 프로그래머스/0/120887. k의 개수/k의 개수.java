class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        while(i <= j){
            String[] arr = String.valueOf(i).split("");
            for(String s : arr){
                int a = (int) Integer.valueOf(s);
                if(a == k){
                    answer++;
                }
            }
            i++;
        }
        return answer;
    }
}