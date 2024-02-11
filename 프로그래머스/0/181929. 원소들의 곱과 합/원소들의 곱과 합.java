class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int muti = 1;
        int total = 0;
        for (int n : num_list){
            muti *= n;
            total += n;
        }
        if (muti < total * total){
            return 1;
        }
        return 0;
    }
}