import java.io.*;
import java.util.Arrays;
class Main{
     private static int[][] dp;
    private static int[][] V;
    private static int N;
    private static int min;


    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // init
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        V = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                V[i][j] = Integer.parseInt(line[j]);
            }
        }


        for(int i = 0; i<N;i++){
            dp = new int[1<<N][N];
            for(int[] row : dp) Arrays.fill(row, -1);

            int m = tsp(1 << i,i,i);
            min = Math.min(min, m);
        }
        System.out.println(min);
    }

    /**
    *최소를 구하는 과정이 최종 목적지에서 출발하여 결과를 기록하며 출발선까지 기록하는 것.
     **/
    private static int tsp(int visited, int current, int start){
        // 최종 목적지에서 드는 비용을 반환
        if(visited == (1<<N) -1){
            if(V[current][start] == 0){
                return Integer.MAX_VALUE;
            }
            return V[current][start];
        }

        if(dp[visited][current] != -1) return dp[visited][current];

        int m = Integer.MAX_VALUE;

        for(int i = 0; i<N;i++){
            // 갈 수 있고 방문을 안했으면
            if(V[current][i] != 0 && (visited & 1<<i) == 0){
                // 다음 방문
                int nextVisit = visited | (1<<i);
                int nextV = tsp(nextVisit, i, start);
                // 기록
                if(nextV != Integer.MAX_VALUE){
                    m = Math.min(m, V[current][i] + nextV);
                }
            }
        }
        return dp[visited][current] = m;
    }
}