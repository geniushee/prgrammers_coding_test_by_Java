import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 초기화
        String line = br.readLine();
        int[] cards = new int[Integer.parseInt(line)];
        int pointer = 0;
        int sum = 0;
        int partSum = 0;
        for(int i = 0; i< cards.length;i++){
            cards[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cards);


        // 계산 가장 작은 애들
        while(pointer != cards.length -1){
            partSum = cards[pointer] + cards[pointer + 1];
            sum += partSum;
            cards[pointer++] = 0;
            cards[pointer] = partSum;
            sort(pointer, cards);
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
    public static void sort(int start, int[] target){
        for(int i = start + 1; i < target.length; i++){
            if(target[i -1] > target[i]){
                int temp = target[i];
                target[i] = target[i-1];
                target[i-1] = temp;
            }else{
                return;
            }
        }
    }
}