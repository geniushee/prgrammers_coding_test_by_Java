import java.io.*;
import java.util.*;

public class Main{
    
static class Node{
        private Node next;
        private Node prev;
        private String value;

        private Node(Node next, Node prev, String value){
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        Map<String, Node> map = new HashMap<>();
        map.put("head", new Node(null, null, ""));
        map.put("tail", new Node(null, null, ""));
        int size = 0;
        int people = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        size = Integer.parseInt(line.split(" ")[0]);
        people = Integer.parseInt(line.split(" ")[1]);

        for(int i=0;i<people;i++){
            String number = br.readLine();
            add(map, number);
        }

        Node node = map.get("head");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < size; i++){
            node = node.next;
            if(node == null || node.value.equals("")){
                break;
            }
            bw.write(node.value + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void add(Map<String, Node> map, String number){
        // 2번째 이후는 꼬리로
        if(map.containsKey(number)){
            goToTail(map, number);
            return;
        }

        Node input = new Node(null, null, number);
        Node head = map.get("head");
        Node tail = map.get("tail");
        // 첫번째
        if(head.next == null && tail.prev == null) {
            head.next = input;
            tail.prev = input;
            input.next  = tail;
            input.prev = head;
            map.put(number, input);
            return;
        }

        // 맨뒤 추가
        input.next = tail;
        input.prev = tail.prev;
        tail.prev.next = input;
        tail.prev = input;
        map.put(number, input);
    }

    private static void goToTail(Map<String, Node> map, String number) {
        Node input = map.get(number);
        Node tail = map.get("tail");

        // 앞뒤 정리
        input.next.prev = input.prev;
        input.prev.next = input.next;

        // tail앞으로 이동
        input.prev = tail.prev;
        input.next = tail;
        tail.prev.next = input;
        tail.prev = input;
    }
}
