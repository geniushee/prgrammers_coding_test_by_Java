import java.io.*;
import java.util.*;

public class Main{
    private static int n;
    private static int m;
    private static int[][] lab;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        lab = new int[n][m];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 벽세우기 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 3);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int row, int col, int wallCount) {
        if (lab[row][col] != 0) {
            return;
        }

        // 벽세우기
        lab[row][col] = 1;
        if (wallCount - 1 == 0) {
            // 바이러스 전파
            int[][] virus = virus();
            // max 갱신
            int temp = countMax(virus);
            if(max < temp){
                max = temp;
            }

            // 나가기 전 원복
            lab[row][col] = 0;
            return;
        }

        int nRow = row;
        int nCol = col;
        while(nRow < n){
            dfs(nRow,nCol++,wallCount -1);
            if(nCol == m){
                nCol = 0;
                nRow++;
            }
        }

        // 나가기 전 원복
        lab[row][col] = 0;
    }

    private static int countMax(int[][] safeZone) {
        int count = 0;
        for(int i =0;i < n;i++){
            for(int j =0; j<m;j++){
                if(safeZone[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] virus(){
        // 바이러스가 퍼질 연구소 복사
        int[][] temp = new int[n][m];
        for(int i =0;i<n;i++){
            temp[i] = Arrays.copyOf(lab[i],m);
        }

        // 바이러스 퍼트리기
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(temp[i][j] == 2){
                    queue.add(new Integer[]{i,j});
                    while(!queue.isEmpty()) {
                        Integer[] e = queue.poll();
                        int row = e[0];
                        int col = e[1];
                        // 좌
                        if (col - 1 >= 0 && temp[row][col-1] == 0) {
                            temp[row][col-1] = 2;
                            queue.add(new Integer[]{row, col - 1});
                        }
                        // 우
                        if (col + 1 < m && temp[row][col+1] == 0) {
                            temp[row][col+1] = 2;
                            queue.add(new Integer[]{row, col + 1});
                        }
                        // 상
                        if (row - 1 >= 0 && temp[row-1][col] == 0) {
                            queue.add(new Integer[]{row - 1, col});
                            temp[row-1][col] = 2;
                        }
                        // 하
                        if (row + 1 < n && temp[row+1][col] == 0) {
                            queue.add(new Integer[]{row + 1, col});
                            temp[row+1][col] = 2;
                        }
                    }
                }
            }
        }

        return temp;
    }
}