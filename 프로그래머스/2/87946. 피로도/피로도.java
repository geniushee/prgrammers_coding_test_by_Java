import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int maxk = k;
        // System.out.println(factorial(dungeons.length));
        
        List<String> patrol = factorial(dungeons.length);
        
        for(String p : patrol){
            int temp = 0;
            k = maxk;
            for(String bit : p.split("")){
                if(k >= dungeons[Integer.valueOf(bit)][0]){
                    k -= dungeons[Integer.valueOf(bit)][1];
                    temp++;
                }
                if(k <= 0){
                    break;
                }
            }
            if(temp > answer){
                answer = temp;
            }
        }
        
        return answer;
    }
    
    public List<String> factorial(int max){
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[max];
        genPermutations(max,"", used, result);
        return result;
    }
    
    public void genPermutations(int n,String current, boolean[] used, List<String> result){
        if(current.length() == n){
            result.add(current);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(!used[i]){
                used[i] = true;
                genPermutations(n, current + i, used, result);
                used[i] = false;
            }
        }
    }
}