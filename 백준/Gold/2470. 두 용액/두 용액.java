import java.io.*;
import java.util.Arrays;

public class Main {
    private static int[] arr;
    private static int min;
    private static int[] answer;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 초기화
        min = Integer.MAX_VALUE;
        answer = new int[2];
        int n = Integer.parseInt(br.readLine());
        String[] els = br.readLine().split(" ");
        arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(els[i]);
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n -1;
        while(left < right){
            int sum = arr[left] + arr[right];
            int abs = Math.abs(sum);
            if(abs < min){
                min = abs;
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
        bw.write(answer[0] + " " + answer[1]+"\n");
        bw.flush();
        bw.close();
    }
}