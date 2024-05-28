import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int deff = n;
        int preDeff = n;
        int idx = 0;
        for(int i =0; i< array.length;i++){
            deff = def(n, array[i]);
            if(deff == preDeff) {
                if(array[i] < array[idx]){
                    idx = i;
                }
            } else if (deff <= preDeff){
                preDeff = deff;
                idx = i;
            }
            // System.out.println("i : " + i + "/ deff : " + deff + "/ idx : " + idx);
        }
        return array[idx];
    }
    public int def(int n, int a){
        if(n > a){
            return n -a;
        } else {
            return a -n;
        }
    }
}