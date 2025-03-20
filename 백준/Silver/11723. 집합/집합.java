import java.io.*;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int set = 0;

    public static void main(String[] args) throws IOException {
        set = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        // 연산 개수 M
        int M = Integer.parseInt(line.trim());

        // input 처리
        while((line = br.readLine())!=null) {
            String[] oper = line.split(" ");
            
            switch (oper[0]) {
                case "add" -> add(Integer.parseInt(oper[1]));
                case "remove" -> remove(Integer.parseInt(oper[1]));
                case "check" -> {
                    if (contain(Integer.parseInt(oper[1]))) {
                        bw.write("1\n");
                    }else{
                        bw.write("0\n");
                    }
                }
                case "toggle" -> toggle(Integer.parseInt(oper[1]));
                case "all" -> all();
                case "empty" -> empty();
            }
        }
        bw.flush();
        bw.close();
    }


    private static void empty() {
        set = 0;
    }

    private static void all() {
        set = 0xfffff;
    }

    private static void toggle(int num) {
        if (!contain(num)) {
            add(num);
        } else {
            remove(num);
        }
    }

    private static void remove(int num) {
        int mask = 1 << num -1;
        set &= ~mask;
    }

    private static void add(int num) {
        int mask = 1 << num -1;
        set |= mask;
    }

    /**
     * num자리가 1인가?
     */
    private static boolean contain(int num) {
        int mask = 1 << num - 1;
        return (set & mask) != 0;
    }
}