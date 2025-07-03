import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] seq = new int[n];
        for(int i = 0;i<n;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;

        int front = 0;
        int back = 0;
        int sum = 0;
        while(true){
            if(sum >= s){
                min = Math.min(min, front - back);
                sum -= seq[back++];
            }else if(front == n){
                break;
            }else{
                sum += seq[front++];
            }
        }
        if(min == Integer.MAX_VALUE){
            bw.write(0+"\n");
        }else {
            bw.write(min + "\n");
        }
        bw.flush();
        bw.close();
    }
}