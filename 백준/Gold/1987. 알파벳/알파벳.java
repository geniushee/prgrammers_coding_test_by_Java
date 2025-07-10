import java.io.*;
import java.util.*;

public class Main{
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int r = Integer.parseInt(line.split(" ")[0]);
        int c = Integer.parseInt(line.split(" ")[1]);
        final int[][] board = new int[r][c];
        Set<Integer> read = new HashSet<>();

        for(int i = 0;i<r;i++){
            line = br.readLine();
            int j = 0;
            for(char c1 : line.toCharArray()){
                board[i][j++] = c1;
            }
        }

        int count = dfs(read, board,0,0,0);

        System.out.println(count == 0? 1:count);
    }

    private static int dfs(Set<Integer> read, int[][] board,int r, int c, int count){
        if(read.contains(board[r][c])){
            return count;
        }
        int max = 0;
        read.add(board[r][c]);

        int nr, nc;
        for(int i = 0; i < 4; i++){
            nr = r + dx[i];
            nc = c + dy[i];
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length){
                continue;
            }
            max = Math.max(max, dfs(read,board,nr,nc,count + 1));
        }

        read.remove(board[r][c]);

        return max;
    }
}