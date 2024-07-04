import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(list);
        if(minHeap.peek() >= K){
            return answer;
        }
        while(minHeap.size() >1){
        Integer a = minHeap.poll();
        Integer b = minHeap.poll();
        minHeap.add(a + b * 2);
        answer++;
            if(minHeap.peek() >= K){
            return answer;
        }
        }
        return -1;
    }
}