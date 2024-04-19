class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] arr = binomial.split(" ");
        switch (arr[1]){
            case "+": answer = (int) Integer.valueOf(arr[0]) + Integer.valueOf(arr[2]);
                break;
            case "-": answer = (int) Integer.valueOf(arr[0]) - Integer.valueOf(arr[2]);
                break;
                case "*": answer = (int) Integer.valueOf(arr[0]) * Integer.valueOf(arr[2]);
                break;
        }
        return answer;
    }
}