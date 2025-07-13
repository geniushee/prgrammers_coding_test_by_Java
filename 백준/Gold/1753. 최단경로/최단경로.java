import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] arg)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        // init graph
        List<int[]>[] graph = new ArrayList[V];
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u-1].add(new int[]{v-1,w});
        }

        // 최단거리를 위한 배열
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K-1] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        heap.offer(new int[]{K-1,0});

        while(!heap.isEmpty()){
            // 현재 노드
            int[] cur = heap.poll();
            int node = cur[0], dis = cur[1];

            // 최단거리 보다 크면 거르기
            if(dis > distance[node]) continue;

            for(int[] next: graph[node]){
                int newDist = dis + next[1];
                if(newDist < distance[next[0]]){
                    distance[next[0]] = newDist;
                    heap.offer(new int[]{next[0], newDist});
                }
                
            }
        }

        // 결과 출력
        for(int i = 0; i < V;i++){
            if(distance[i] == Integer.MAX_VALUE){
                bw.write("INF\n");
            }else{
                bw.write(distance[i] +"\n");
            }
            bw.flush();
        }
        bw.close();
    }
}