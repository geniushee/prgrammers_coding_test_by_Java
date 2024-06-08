class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int min = 0;
        int max = 0;
        for(int[] arr : lines){
            for(int i : arr){
                if(i <= min){
                    min = i;
                    continue;
                } else if(i >= max){
                    max = i;
                    continue;
                }
            }
        }
        // System.out.println("min : " + min + ", max : " + max);
        for(int i = min; i < max; i++){
            int check = 0;
            if(valid(lines[0], i)){
            check++;
        }
            if(valid(lines[1], i)){
                check++;
            }
            if(valid(lines[2], i)){
                check++;
            }
            if(check >=2){
                answer++;
            }
            // System.out.println("i : " + i + ", answer : " + answer);
        }
        
        
        return answer;
    }
    
    boolean valid(int[] arr, int i){
        if(arr[0] <= i && arr[1] >= i+1){
            return true;
        } else{
            return false;
        }
    }
}