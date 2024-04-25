import java.math.BigDecimal;

class Solution {
    public String solution(String a, String b) {
        BigDecimal sa = new BigDecimal(a);
        BigDecimal sb = new BigDecimal(b);
        BigDecimal n = sa.add(sb);
        String answer = n.toString();
        return answer;
    }
}