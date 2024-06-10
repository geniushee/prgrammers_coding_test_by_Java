import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        Double[] avg = Arrays.stream(score).map(arr -> (arr[0] + arr[1])/2.0).toArray(Double[]::new);
        Double[] rank = Arrays.stream(score).map(arr -> (arr[0] + arr[1])/2.0).toArray(Double[]::new);
        Arrays.sort(avg, Collections.reverseOrder());
        // System.out.println(Arrays.toString(avg));
        // System.out.println(Arrays.toString(rank));
        int[] res = new int[rank.length];
        int r = 1;
        int pass = 0;
        for(int j = 0; j < avg.length;j++){
            Double a = avg[j];
            if(j != 0 && a.equals(avg[j-1])){
                continue;
            }else{
                pass=0;
            }
            // System.out.println("a : " + a);
            for(int i = 0; i < avg.length;i++){
                // System.out.println("ele : " +rank[i]);
            if(rank[i].equals(a)){
                res[i] = r;
                pass++;
            }
                
        }
            // System.out.println(Arrays.toString(res));
            r+=pass;
        }
        
        return res;
    }
}