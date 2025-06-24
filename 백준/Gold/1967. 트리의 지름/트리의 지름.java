import java.io.*;
import java.util.*;

class Main{
    private static int longestNode = 0;
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // init
        int n = Integer.parseInt(br.readLine());
        List<Node>[] graph = new ArrayList[n+1];
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1;i++){
            String[] nums = br.readLine().split(" ");
            graph[Integer.parseInt(nums[0])]
                    .add(new Node(Integer.parseInt(nums[1]), Integer.parseInt(nums[2])));
            graph[Integer.parseInt(nums[1])]
                    .add(new Node(Integer.parseInt(nums[0]), Integer.parseInt(nums[2])));
        }
        dfs(graph, 0,1,0);
        // max init
        max = Integer.MIN_VALUE;
        dfs(graph, 0, longestNode,0);
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    private static void dfs(List<Node>[] graph, int preNode, int curNode, int length) {
        if(max < length){
                max = length;
                longestNode = curNode;
            }
        for(Node node : graph[curNode]){
            if(node.to == preNode){
                continue;
            }
            dfs(graph, curNode, node.to,length + node.weight);
        }
    }

    static class Node{
        int to, weight;
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}