import java.io.*;

class Main{
    static long[] arr, tree;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        arr = new long[n+1];
        tree = new long[4*n];
        for(int i = 1; i < n+1; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        buildTree(1,n,1);

        for(int i = 0; i < m+k;i++){
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            long c = Long.parseLong(line[2]);

            if(a == 1){
                update(1,n,1,b,c);
            }else{
                long sum = query(1,n, 1,b, (int) c);
                bw.write(sum + "\n");
                bw.flush();
            }
        }
        bw.close();
    }
    private static long buildTree(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        long left = buildTree(start, mid, node * 2);
        long right = buildTree(mid + 1, end, node * 2 + 1);
        return tree[node] = left + right;
    }

    private static long query(int start, int end, int node, int b, int c) {
        if(b <= start && c >= end) return tree[node];
        if(end < b || c < start) return 0;
        int mid = (start + end) / 2;
        long left = query(start, mid, node * 2, b, c);
        long right = query(mid + 1, end, node * 2 +1, b,c);
        return left + right;
    }

    private static long update(int start, int end,int node, int b, long c) {
        if(b < start || b > end) return tree[node];
        if(start == end) return tree[node] = c;
        int mid = (start + end) / 2;
        long left = update(start, mid, node * 2, b,c);
        long right = update(mid + 1, end, node * 2 + 1, b,c);
        return tree[node] = left + right;
    }
}