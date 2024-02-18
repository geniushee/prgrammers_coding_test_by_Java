import java.lang.Integer;
import java.util.ArrayList;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = l; i <= r; i++){
            String str = String.valueOf(i);
            boolean flag = false;
            for (char c : str.toCharArray()){
                if (c != '5' && c != '0') {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag){
                list.add(i);
            }
        }
        if (list.isEmpty()){
            return new int[]{-1};
        } else{
            int[] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}