import java.util.*;
class Solution {
    public String solution(String bin1, String bin2) {
        int len1 = bin1.length();
        int len2 = bin2.length();
        String[] a1;
        String[] a2;
        String[] a3;
        if(len1 > len2){
            a1 = new String[len1 + 1];
            a2 = new String[len1 + 1];
            a3 = new String[len1 + 1];
        }else {
            a1 = new String[len2 + 1];
            a2 = new String[len2 + 1];
            a3 = new String[len2 + 1];
        }
        
        for(int i = 0; i < a1.length; i++){
            if(i < a1.length - len1){
                a1[i] = "0";
            }else {
                a1[i] = bin1.split("")[i - a1.length + len1];
            }
            if(i < a2.length - len2){
                a2[i] = "0";
            }else {
                a2[i] = bin2.split("")[i - a2.length + len2];
            }
        }
        // System.out.println(Arrays.toString(a1));
        // System.out.println(Arrays.toString(a2));
        int up = 0;
        for(int i = 1; i <= a1.length; i++){
            String a = a1[a1.length -i];
            String b = a2[a2.length -i];
            int sum = Integer.valueOf(a) + Integer.valueOf(b) + up;
            if(sum >= 2){
                up = 1;
                a3[a3.length -i] = String.valueOf(sum - 2);
            }else{
                up = 0;
                a3[a3.length -i] = String.valueOf(sum);
            }
            // System.out.println(Arrays.toString(a3));
        }
        String answer = "";
        for(int i = 0; i < a3.length; i++){
            if(i == 0 && a3[i].equals("0")){
                continue;
            }
            answer += a3[i];
        }
        return answer;
    }
}