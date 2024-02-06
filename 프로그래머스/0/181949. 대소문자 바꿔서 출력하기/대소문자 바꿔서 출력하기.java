import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String res = "";
        for (char c : a.toCharArray()){
            if (Character.isLowerCase(c)){
                res = res + Character.toUpperCase(c);
            }else{
                res = res + Character.toLowerCase(c);
            }
        }
        System.out.print(res);
    }
}