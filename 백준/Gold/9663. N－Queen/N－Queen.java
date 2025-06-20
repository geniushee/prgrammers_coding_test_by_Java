import java.io.*;

public class Main {
    private static int answer;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int j = 0; j < N; j++) {
            dfs(board, 0, j, 0);
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int[][] board, int x, int y, int now) {
        // col에 있는가?
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == 1) {
                return;
            }
        }
        // 좌상향에 있는가?
        for (int i = 0; i <= x; i++) {
            if(y - x + i < 0){
                continue;
            }
            if (board[i][y - x + i] == 1) {
                return;
            }
        }
        // 우상향에 있는가?
        for (int i = 0; i <= x; i++) {
            if(x + y - i >= board.length){
                continue;
            }
            if (board[i][x + y - i] == 1) {
                return;
            }
        }
        board[x][y] = 1;
        int renew = now + 1;
        if (renew == board.length) {
            answer += 1;
            board[x][y] = 0;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board, x + 1, i, renew);
        }
        board[x][y] = 0;
    }
}