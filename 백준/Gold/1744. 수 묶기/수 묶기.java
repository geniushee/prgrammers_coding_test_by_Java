import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 양수
        PriorityQueue<Integer> plus = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 음수
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int sum = 0;
        int zero = 0;
        for(int i = 0; i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                zero++;
                continue;
            }
            if(num == 1){
                sum += num;
            }else if(num > 0){
                plus.offer(num);
            }else{
                minus.offer(num);
            }
        }

        while(plus.size() > 1){
            int n1 = plus.poll();
            int n2 = plus.poll();
            sum += n1 * n2;
        }
        if(!plus.isEmpty()){
            sum += plus.poll();
        }

        while(minus.size() > 1){
            int n1 = minus.poll();
            int n2 = minus.poll();
            sum += n1 * n2;
        }
        if(zero == 0 && !minus.isEmpty()){
            sum += minus.poll();
        }

        System.out.println(sum);
    }
}