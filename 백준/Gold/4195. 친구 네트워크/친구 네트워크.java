import java.io.*;
import java.util.*;

class Main{
// 이름에 ID를 부여
    private static Map<String, Integer> nameToId;
    private static int[] parent;
    private static int[] size;

    /**
     * Union-find 자료구조를 사용하여 구현
     * @param arg
     * @throws IOException
     */
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 케이스  N회
        for(int n = 0; n<N;n++){
            int F = Integer.parseInt(br.readLine());
            parent =new int[F*2];
            size = new int[F*2];
            nameToId = new HashMap<>();
            int id = 0;

            for(int f = 0; f<F;f++){
                String[] line = br.readLine().split(" ");

                if(!nameToId.containsKey(line[0])){
                    nameToId.put(line[0], id);
                    parent[id] = id;
                    size[id]++;
                    id++;
                }
                if(!nameToId.containsKey(line[1])){
                    nameToId.put(line[1], id);
                    parent[id] = id;
                    size[id]++;
                    id++;
                }
                int p1 = nameToId.get(line[0]), p2 = nameToId.get(line[1]);
                union(p1, p2);

                System.out.println(size[find(p1)]);
            }
        }


    }

    /**
     * 부모 찾기<br>
     * 속해 있는 집답의 루트를 찾아서 반환
     * @param x 가 어떤 집합에 속해 있는지 찾기
     * @return x가 속해 있는 집합의 최종 루트 반환
     */
    private static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * 집합 합치기<br>
     * 합치고자 하는 집합의 어떤 원소 x,y를 사용하여 두 집합을 크기 기준으로 합한다.
     * @param x 어떤 집합의 한 원소
     * @param y 어떤 집합의 한 원소
     */
     private static void union(int x, int y){
        int rx = find(x);
        int ry = find(y);
        if(rx != ry){
            if(size[rx] > size[ry]){
                size[rx] = size[rx] + size[ry];
                parent[ry] = rx;
            }else{
                size[ry] = size[ry] + size[rx];
                parent[rx] = ry;
            }
        }
     }
}