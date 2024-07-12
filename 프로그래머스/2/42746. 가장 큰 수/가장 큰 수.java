import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        
        for(int i =0; i < numbers.length; i++){
            strings[i] = String.valueOf(numbers[i]);
        }
        // System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                // System.out.println("시작");
                int a =(int) Integer.valueOf(s1 + s2);
                int b =(int) Integer.valueOf(s2 + s1);
                if(a > b){
                    return -1;
                }
                if(a < b){
                    return 1;
                }
                return 0;
            }
        });
        
        // System.out.println(Arrays.toString(strings));
        
        StringBuilder sb = new StringBuilder();
        for(String s : strings){
            sb.append(s);
        }
        
        String answer = sb.toString();
        
        while(!answer.equals("0")){
            if(answer.charAt(0) == '0'){
                answer = answer.substring(1);
            }else{
                break;
            }
        }
        
        return answer;
    }
}