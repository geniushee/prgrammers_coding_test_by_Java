import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        List<Double> list = new ArrayList<>();
        
        for(int i = 0; i < dots.length; i++){
            for(int j = i + 1; j < dots.length; j++){
                Double d = Double.valueOf(dots[j][1] - dots[i][1]) / Double.valueOf(dots[j][0] - dots[i][0]);
                list.add(d);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
        for(int i = 0; i < 3; i++){
            if(list.get(i).equals(list.get(5-i))){
                return 1;
            }
        }
        return 0;
    }
}