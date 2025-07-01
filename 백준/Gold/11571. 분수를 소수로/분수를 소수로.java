import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringBuilder answer = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] res;
            // 정수부분 계산
            res = divide(a, b);
            answer.append(res[0]);
            answer.append(".");
            a = res[1] * 10;

            // 0. init 목:{인덱스, 나머지}
            Map<Integer, List<int[]>> map = new HashMap<>();
            // 소수부분
            List<Integer> ground = new ArrayList<>();

            int start = -1;
            int end = -1;
            int k = 0;
            boolean find = false;
            while (!find) {
                // 1. 나눈다.
                res = divide(a, b);
                // 나눈 값을 적용
                if (res[0] == 0 && res[1] == 0) {
                    // 나누어 떨어진다.
                    break;
                }
                ground.add(res[0]);


                // 2. 순환이 있는지 확인한다. => 패턴이 있다 = 몫과 나머지가 일치한다.
                // 몫이 같은 친구들을 불러온다.
                List<int[]> list = map.getOrDefault(res[0], new ArrayList<>());
                for (int[] arr : list) {
                    // 나머지가 같다.
                    if (res[1] == arr[1]) {
                        start = arr[0];
                        end = k;
                        find = true;
                        break;
                    }
                }
                list.add(new int[]{k++, res[1]});
                map.put(res[0], list);
                // 분모 갱신
                a = res[1] * 10;
                // 3. 1번으로
            }

            // 답안지 작성
            if (start == -1) {
                for (Integer num : ground) {
                    answer.append(num);
                }
                answer.append("(0)");
            } else {
                for (int x = 0; x < start; x++) {
                    answer.append(ground.get(x));
                }
                answer.append("(");
                for (int x = start; x < end; x++) {
                    answer.append(ground.get(x));
                }
                answer.append(")");
            }
            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static int[] divide(int son, int parent) {
        // 몫, 나머지
        int[] res = new int[2];
        // 0은 나눌 수 없다.
        if (son == 0) {
            return res;
        }
        res[0] = son / parent;
        res[1] = son % parent;
        return res;
    }
}