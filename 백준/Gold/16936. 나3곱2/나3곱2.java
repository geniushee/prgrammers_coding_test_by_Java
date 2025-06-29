import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, PriorityQueue<Long>> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        long[] answer = new long[n];
        int maxMod = 0;
        String[] nums = br.readLine().split(" ");
        for(String num : nums){
            Long i = Long.valueOf(num);
            int mod = count3(i);
            PriorityQueue<Long> heap = map.getOrDefault(mod, new PriorityQueue<>());
            heap.offer(i);
            map.put(mod, heap);
            if(mod > maxMod){
                maxMod = mod;
            }
        }

        int i = 0;
        while(maxMod >= 0){
            PriorityQueue<Long> heap = map.getOrDefault(maxMod, null);
            if(heap != null){
                while(!heap.isEmpty()){
                    answer[i++] = heap.poll();
                }
            }
            maxMod--;
        }
        for(int j = 0; j<n;j++){
            bw.write(answer[j]+"");
            if(j != n -1){
                bw.write(" ");
            }else{
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static int count3(long num){
        int count = 0;
        long mod = 0;
        while(true){
            mod = num % 3;
            if(mod == 0){
                num /= 3;
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}