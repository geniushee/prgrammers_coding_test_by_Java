import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        List<String> list = new ArrayList<>();    
        for(String q : quiz){
        String[] arr = q.split(" ");
            if(arr[1].equals("+")){
                int a = Integer.valueOf(arr[0]) + Integer.valueOf(arr[2]);
                if(a == Integer.valueOf(arr[4])){
                    list.add("O");
                } else{
                    list.add("X");
                }
            }else{
                int a = Integer.valueOf(arr[0]) - Integer.valueOf(arr[2]);
                if(a == Integer.valueOf(arr[4])){
                    list.add("O");
                } else{
                    list.add("X");
                }
            }
        }
        return list.toArray(String[]::new);
    }
}