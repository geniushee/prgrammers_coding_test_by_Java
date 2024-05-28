class Solution {
    public int solution(int order) {
        int answer = 0;
        String s = String.valueOf(order).replaceAll("([1-2|4-5|7-8|0])","");
        System.out.println(s);
        return s.length();
    }
}