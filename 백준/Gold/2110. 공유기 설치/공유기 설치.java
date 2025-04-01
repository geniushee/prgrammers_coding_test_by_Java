import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] bits = line.split(" ");
        int N = Integer.parseInt(bits[0]);
        int C = Integer.parseInt(bits[1]);

        // 오름차순으로 정렬
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        //범위 설정
        int right = houses[N - 1] - houses[0];
        int left = 1;

        while (left < right) {
            int mid = (right + left + 1) / 2;
            if (!condition(mid, C, houses)) {
                right = mid -1;
            }else {
                left = mid;
            }

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(left + "\n");
        bw.flush();
        bw.close();
    }
    
    private static boolean condition(int key, int count, int[] houses) {
        int lastPlaced = houses[0];
        count--;

        for(int i = 0;i< houses.length;i++) {
            if(houses[i] - lastPlaced >= key){
                count--;
                lastPlaced = houses[i];
            }
            if(count == 0){
                return true;
            }
        }
        return false;
    }
}