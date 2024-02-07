import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = n % 2;
        switch (mod){
            case 1: System.out.printf("%d is odd", n); break;
            case 0: System.out.printf("%d is even", n); break;}
        
    }
}