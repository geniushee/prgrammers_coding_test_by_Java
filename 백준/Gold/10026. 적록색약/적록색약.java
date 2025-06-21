import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // init
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[][] image = new int[N][N];
        boolean[][] red = new boolean[N][N];
        boolean[][] green = new boolean[N][N];
        boolean[][] blue = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int normal = 0;
        int blind = 0;

        // set image, red = 1, green = 2, blue = 3
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            int j = 0;
            for (String s : line.split("")) {
                int e = 0;
                switch (s) {
                    case "R" -> e = 1;
                    case "G" -> e = 2;
                    case "B" -> e = 3;
                }
                image[i][j++] = e;
            }
        }

        // find section
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean flag = false;
                if (!red[i][j] && !green[i][j] && !blue[i][j]) {
                    switch (image[i][j]) {
                        case 1 -> {
                            if (red[i][j]) {
                                continue;
                            }
                            red[i][j] = true;
                        }
                        case 2 -> {
                            if (green[i][j]) {
                                continue;
                            }
                            green[i][j] = true;
                        }
                        case 3 -> {
                            if (blue[i][j]) {
                                continue;
                            }
                            blue[i][j] = true;
                        }
                    }
                    queue.offer(new int[]{i, j, image[i][j]});
                    flag = true;
                }
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }
                        if (now[2] == image[nx][ny]) {
                            switch (now[2]) {
                                case 1 -> {
                                    if (red[nx][ny]) {
                                        continue;
                                    }
                                    red[nx][ny] = true;
                                }
                                case 2 -> {
                                    if (green[nx][ny]) {
                                        continue;
                                    }
                                    green[nx][ny] = true;
                                }
                                case 3 -> {
                                    if (blue[nx][ny]) {
                                        continue;
                                    }
                                    blue[nx][ny] = true;
                                }
                            }
                            queue.offer(new int[]{nx, ny, image[nx][ny]});
                        }
                    }
                }
                if (flag) {
                    normal++;
                }
            }
        }
        bw.write(normal+"\n");

        //init
        red = new boolean[N][N];
        blue = new boolean[N][N];
        // find section
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean flag = false;
                if (!red[i][j] && !blue[i][j]) {
                    switch (image[i][j]) {
                        case 1, 2 -> {
                            if (red[i][j]) {
                                continue;
                            }
                            red[i][j] = true;
                        }
                        case 3 -> {
                            if (blue[i][j]) {
                                continue;
                            }
                            blue[i][j] = true;
                        }
                    }
                    queue.offer(new int[]{i, j, image[i][j]});
                    flag = true;
                }
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }
                        if (now[2] == 3 && image[nx][ny] == 3) {
                            if (blue[nx][ny]) {
                                continue;
                            }
                            blue[nx][ny] = true;
                            queue.offer(new int[]{nx, ny, image[nx][ny]});
                        } else if(now[2] != 3 && (image[nx][ny] == 1 || image[nx][ny] == 2)) {
                            if (red[nx][ny]) {
                                continue;
                            }
                            red[nx][ny] = true;
                            queue.offer(new int[]{nx, ny, image[nx][ny]});
                        }
                    }
                }
                if (flag) {
                    blind++;
                }
            }
        }
        bw.write(blind+"\n");
        bw.flush();
        bw.close();
    }
}