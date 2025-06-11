import java.util.*;
import java.io.*;

public class Main{
    public static Queue<String> search(final int c,final int l,final String[] strs){
        // 오름차순 정렬
        Arrays.sort(strs);
        // answer
        Queue<String> answer = new LinkedList<>();

        String current = "";
        for(int i = 0; i < l; i++){
            dfs(c, l, i, current + strs[i] ,answer, strs);
        }

        return answer;
    }

    private static void dfs(int c, int l, int i, String current, Queue<String> answer, String[] strs) {
        if(current.length() == c){
            int mo = 0;
            int ja = 0;
            List<Character> aeiou = List.of('a', 'e', 'i', 'o','u');
            for(Character a : current.toCharArray()){
                if(aeiou.contains(a)){
                    mo++;
                }else{
                    ja++;
                }

                if(mo > 0 && ja > 1){
                    answer.add(current);
                    return ;
                }
            }
            return ;
        }

        for(int j = i+1; j < l; j++){
            dfs(c,l,j,current + strs[j], answer, strs);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);
        int c = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        String[] strs = new String[l];
        int i = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            strs[i++] = st.nextToken();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String bit : search(c,l, strs)){
            bw.write(bit+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}