class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        int sum = Integer.valueOf(arr[0]);
        int a = 0;
        int b = 0;
        
        for(int i = 1; i < arr.length; i+=2){
                switch (arr[i]) {
                    case "+" : sum += Integer.valueOf(arr[i+1]); break;
                    case "-" : sum -= Integer.valueOf(arr[i+1]); break;
        }
        
    }
        return sum;
    }
}