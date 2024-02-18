import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int r = 0; r < queries.length; r++) {
            int[] query = queries[r]; 
            IntStream.range(query[0],query[1] + 1).filter(i -> i % query[2]== 0)
                    .forEach(i -> arr[i] += 1);
        }
        return arr;
    }
}