import java.io.*;

public class Main{
    private static int n;
    private static int k;
    private static int[] maxValueOfweight;
    private static Thing[] things;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 초기화
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        maxValueOfweight = new int[k + 1];
        maxValueOfweight[0] = 0;

        things = new Thing[n];
        for(int i = 0; i<n;i++) {
            line = br.readLine().split(" ");
            things[i] =  new Thing(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
        }
        visited = new boolean[n];

        // 첫번째 물건 넣기
        for(int i = 0; i < n; i++){
            for(int j = k; j >= things[i].weight; j--){
                maxValueOfweight[j] = Math.max(maxValueOfweight[j], maxValueOfweight[j - things[i].weight] + things[i].value);
            }
        }

        int maxValue = 0;
        for(int value : maxValueOfweight){
            if(maxValue < value){
                maxValue = value;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(maxValue + "\n");
        bw.flush();
        bw.close();
    }
    
    static class Thing{
        private final int weight;
        private final int value;

        private Thing(int w, int v){
            weight = w;
            value = v;
        }
    }
}