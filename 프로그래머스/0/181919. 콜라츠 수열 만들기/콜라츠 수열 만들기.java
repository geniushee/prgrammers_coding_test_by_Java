import java.util.ArrayList;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        while(n != 1){
            n = check(n);
            list.add(n);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    public int check(int num){
        if (num % 2 == 0){
            return num / 2;
        } else {
            return num * 3 + 1;
        }
    }
}