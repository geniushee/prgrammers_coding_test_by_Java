class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] q : queries){
            int first = q[0];
            int second = q[1];
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
        return arr;
    }
}