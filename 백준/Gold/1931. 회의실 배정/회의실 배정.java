import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Integer[][] meetings = new Integer[N][2];
        for(int i =0;i<N;i++){
            String line = br.readLine();
            String[] bit = line.split(" ");
            meetings[i][0] = Integer.parseInt(bit[0]);
            meetings[i][1] = Integer.parseInt(bit[1]);
        }

        // 미팅룸 끝나는 시간이 늦은 순으로 정렬, 끝나는 시간이 같다면 더 늦게 시작하는 순서로.
        Arrays.sort(meetings, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(!Objects.equals(o1[1], o2[1])){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

//        System.out.println(Arrays.deepToString(meetings));

        int start = meetings[0][0], end = meetings[0][1];
        int count = 1;

        for(int i=1;i<N;i++){
            if(end <= meetings[i][0]){
//                System.out.println(Arrays.toString(meetings[i]));
                start = meetings[i][0];
                end = meetings[i][1];
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}