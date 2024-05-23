import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        int m = 2;
        while(n != 1){
            if(n % m == 0){
                set.add(m);
                n /= m;
            } else {
                m++;
            }
        }
        
        int[] answer = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int i = 0;
        while(it.hasNext()){
            answer[i] = it.next();
            i++;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}