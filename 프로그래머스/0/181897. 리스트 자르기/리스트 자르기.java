class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int len = num_list.length;
        switch (n){
            case 1: answer = new int[slicer[1] + 1];
                for(int i = 0; i <= slicer[1];i++){
                    answer[i] = num_list[i];
                }
                break;
            case 2: answer = new int[len - slicer[0]];
                for (int i = 0; i<len - slicer[0];i++){
                    answer[i] = num_list[slicer[0] + i];
                }
                break;
            case 3: answer = new int[slicer[1] - slicer[0] + 1];
                for (int i = 0; i < slicer[1] - slicer[0] + 1; i++){
                    answer[i] = num_list[slicer[0] + i];
                }
                break;
            case 4: int mod = (slicer[1] - slicer[0]) / slicer[2] + 1;
                answer = new int[mod];
                for (int i = 0; i < mod; i++){
                    int idx = slicer[0] + i * slicer[2];
                    answer[i] = num_list[idx];
                }
                break;
        }
        return answer;
    }
}