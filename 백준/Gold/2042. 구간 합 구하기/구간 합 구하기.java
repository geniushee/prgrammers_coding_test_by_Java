import java.io.*;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        long[] arr = new long[n+1];
        for(int i = 1; i < n+1; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        String flag;

        for(int i = 0; i<m+k;i++){
            line = br.readLine().split(" ");
            flag = line[0];
            switch(flag){
                case "1" -> change(arr, line[1], line[2]);
                case "2" ->{
                    long sum = partSum(arr, line[1], line[2]);
                    bw.write(sum + "\n");
                    bw.flush();
                }
            }
        }
        bw.close();
    }
    private static long partSum(long[] arr, String s, String e) {
        int start = Integer.parseInt(s);
        int end = Integer.parseInt(e);
        long sum = 0;
        for(int i = start; i<=end; i++){
            sum += arr[i];
        }
        return sum;
    }

    private static void change(long[] arr, String preIdx, String changed) {
        int idx = Integer.parseInt(preIdx);
        arr[idx] = Long.parseLong(changed);
    }
}