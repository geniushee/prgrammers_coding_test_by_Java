import java.io.*;
import java.util.*;
public class Main{
    private static int[][] box;

    static class Axis {
        private int x;
        private int y;
        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        box = new int[n][m];
        int unripeCount = 0;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int day = 0;

        // 박스, 전체, 안익은 토마토 정리
        Queue<Axis> queue = new LinkedList<>();
        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                int tomato = Integer.parseInt(line[j]);
                if (tomato != -1) {
                    if (tomato == 0) {
                        unripeCount++;
                    } else {
                        // 익은 토마토 넣기
                        queue.add(new Axis(i, j));
                    }
                }
                box[i][j] = tomato;
            }
        }

        // 이미 다 익음
        if(unripeCount == 0){
            bw.write(0+"\n");
            bw.flush();
            bw.close();
            return ;
        }

        // 익은 토마토 확산
        while (!queue.isEmpty()) {
            Axis axis = queue.poll();
            for(int k = 0;k<4;k++) {
                int x = axis.x + dx[k];
                int y = axis.y + dy[k];
                if (x >= 0 && x < n && y >= 0 && y < m && box[x][y] == 0) {
                    box[x][y] = box[axis.x][axis.y] + 1;
                    queue.offer(new Axis(x, y));
                }
            }
        }

        // 다 안 익음
        if(unripe()){
            bw.write(-1+"\n");
            bw.flush();
            bw.close();
            return ;
        }

        bw.write((maxday(box) - 1)+"\n");
        bw.flush();
        bw.close();
    }
    private static boolean unripe() {
        for(int[] row : box){
            for(int col : row){
                if(col == 0){
                    return true;
                }
            }
        }
        return false;
    }
    private static int maxday(int[][] box) {
        int max = 1;
        for(int i = 0;i<box.length;i++){
            for(int j =0;j<box[i].length; j++){
                if(max < box[i][j]){
                    max = box[i][j];
                }
            }
        }
        return max;
    }
}