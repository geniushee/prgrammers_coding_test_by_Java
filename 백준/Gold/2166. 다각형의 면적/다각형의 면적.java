import java.io.*;

public class Main{
    public static void main(String[] arg) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n+1][2];
        for(int i = 0; i<arr.length - 1;i++){
            String[] point = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(point[0]);
            arr[i][1] = Integer.parseInt(point[1]);
        }
        // 첫 점 다시 넣기
        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];

        long sum = 0;
        for(int i = 0; i<n;i++){
            sum += arr[i][0] * arr[i+1][1] - arr[i+1][0] * arr[i][1];
        }
        double answer = Math.abs(sum) / 2.0;

        bw.write(String.format("%.1f\n", answer));
        bw.flush();
        bw.close();
    }
}