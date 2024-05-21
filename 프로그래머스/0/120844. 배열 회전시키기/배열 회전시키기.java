class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        switch (direction){
            case "right" : answer = right(numbers); break;
            case "left" : answer = left(numbers); break;
        }
        return answer;
    }
    public int[] right(int[] arr){
        int len = arr.length;
        int[] res = new int[len];
        for(int i = len - 1;i - len + 1 < len;i++){
            int idx1 = i % len;
            int idx2 = (i + 1) % len;
            res[idx2] = arr[idx1];
        }
        return res;
    }public int[] left(int[] arr){
        int len = arr.length;
        int[] res = new int[len];
        for(int i = 1;i - 1 < len;i++){
            int idx1 = i % len;
            int idx2 = (i - 1) % len;
            res[idx2] = arr[idx1];
        }
        return res;
    }
}