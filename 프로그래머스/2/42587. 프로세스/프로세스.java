import java.util.*;
class Solution {
    public int solution(int[] pri, int location) {
        int count = 0;
        int len = pri.length;
        Integer[] desc = new Integer[pri.length];
        for(int i = 0; i < len;i++){
            desc[i] = pri[i];
        }
        Arrays.sort(desc, Collections.reverseOrder());
        
        for(int i=0; i < len;){
            int a =(int) desc[i];
            int b = pri[i];
            if(a == b){
                desc[i] = 0;
                pri[i] = 0;
                count++;
                // System.out.println(Arrays.toString(desc));
                // System.out.println(Arrays.toString(pri));
                if(i == location){
                    // System.out.println("끝");
                    return count;
                }
                i++;
                // System.out.println("count : "+count+", 위치 : " + location);
            }else{
                pri = change(pri,i);
                if(location == i){
                    location = len - 1;
                }else{
                    location--;
                }
                // System.out.println("위치 : "+location +", 밀기 : " + Arrays.toString(pri));
            }
        }
        
        
        return count;
    }
    
    public int[] change(int[] arr, int start){
            int temp = arr[start];
            for(int j = start+1;j < arr.length; j++){
                arr[j-1] = arr[j];
            }
            arr[arr.length -1] = temp;
        return arr;
    }
}