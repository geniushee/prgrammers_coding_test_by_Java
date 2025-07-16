import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] minDistance = new int[N + 1];
        // idx = 출발지점, [0] = 도착지점, [1] = cost
        List<int[]>[] buses = new ArrayList[N + 1];
        for (int n = 0; n < N + 1; n++) {
            buses[n] = new ArrayList<>();
            minDistance[n] = Integer.MAX_VALUE;
        }

        // 버스 초기화
        StringTokenizer st;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            buses[idx]
                    .add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        minDistance[start] = 0;
        heap.offer(new int[]{start, 0});


        int min = Integer.MAX_VALUE;
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int curNode = cur[0];
            int curCost = cur[1];

//            System.out.printf("현재 node %d / 현재 코스트 %d\n", curNode, curCost);
            if (curCost > minDistance[curNode]) {
                continue;
            }

            for (int[] bus : buses[curNode]) {
                int next = bus[0];
                int totalCost = curCost + bus[1];
                if (minDistance[next] > totalCost) {
//                    System.out.println("다음으로");
                    minDistance[next] = totalCost;
                    heap.offer(new int[]{next, totalCost});
                }
            }
        }
        System.out.println(minDistance[end]);
    }
}