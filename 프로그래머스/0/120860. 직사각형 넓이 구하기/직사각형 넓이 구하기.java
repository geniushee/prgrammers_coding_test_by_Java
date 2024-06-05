import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = 0;
        int y = 0;
        Set<Integer> arrx = new HashSet<>();
        Set<Integer> arry = new HashSet<>();
        
        for(int i = 0; i< dots.length; i++){
            arrx.add(dots[i][0]);
        }
            for(int i = 0; i< dots.length; i++){
            arry.add(dots[i][1]);
        }
        int temp = 0;        
        Iterator itx = arrx.iterator();
        x =(int) itx.next();
        temp =(int) itx.next();
        if(x > temp){
            x = x - temp;
        }else{
            x = temp - x;
        }
        
        Iterator ity = arry.iterator();
        y = (int) ity.next();
        temp = (int) ity.next();
        if(y > temp){
            y = y - temp;
        }else{
            y = temp - y;
        }
        return x * y;
    }
}