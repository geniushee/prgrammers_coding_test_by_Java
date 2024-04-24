import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] atd) {
        List<Integer> abc = new ArrayList<>();
        
        for(int i = 0; i < rank.length; i++){
            // System.out.println("지금 등수: " + (i + 1));
                int num = indexOf(rank, i+1);
            if(num == -1){continue;}
            // System.out.println("번호 : " + num);
            // System.out.println("출석여부 : " + atd[num]);
                if (atd[num]){
                    // System.out.println("추가");
                    abc.add(num);
                }
        }
        int a = abc.get(0);
        int b = abc.get(1);
        int c = abc.get(2);
        return 10000 * a + 100 * b + c;
    }
    
    public int indexOf(int[] arr, int val){
        for(int i = 0; i < arr.length; i++){
            if(val == arr[i]){
                return i;
            }
        }
        return -1;
    }
}