import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < strArr.length; i++){
            int len = strArr[i].length();
            
            if(list.size() >= len){
                list.set(len - 1, list.get(len - 1) + 1);
            } else {
                while(list.size() < len){
                    list.add(0);
                }
                list.set(len - 1, list.get(len - 1) + 1);
            }
            // System.out.println(list);
        }
        return(int) Collections.max(list);
    }
}