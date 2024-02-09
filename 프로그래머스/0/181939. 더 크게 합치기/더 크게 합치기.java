class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str1 = "" + a + b;
        String str2 = "" + b + a;
        
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        
        if (i > j){
            return i;
        }
        
        return j;
    }
}