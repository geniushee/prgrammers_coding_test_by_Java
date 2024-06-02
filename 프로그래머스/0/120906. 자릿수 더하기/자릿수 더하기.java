class Solution {
    public int solution(int n) {
        int s = 0;
        for(String a : String.valueOf(n).split("")){
            s += Integer.valueOf(a);
        }
        return s;
    }
}