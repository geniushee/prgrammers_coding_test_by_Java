class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        StringBuilder b = new StringBuilder();
        for(char c : arr){
            for(int i = 0; i<n;i++){
                b.append(c);
            }
        }
        return b.toString();
    }
}