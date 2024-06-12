class Solution {
    public int solution(int chicken) {
        int service = chicken / 10;
        int quotient = service;
        int remain = chicken % 10;
        chicken = (quotient + remain);
        while(chicken / 10 > 0){
            quotient = chicken / 10;
            remain = chicken % 10;
            service += quotient;
            chicken = (quotient + remain);
        }
        return service;
    }
}