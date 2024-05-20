class Solution {
    public int solution(int balls, int share) {
        long up = 1;
        long dn = 1;
        long answer = 1;
        for(int i = 0; i < share; i++){
            up = (balls - i);
            dn *= (dn + i);
            answer *= up;
            if(answer % dn == 0){
                answer /= dn;
                dn = 1;
            }
            System.out.println(i+ " : " +up + " " + dn + " " + answer);
        }
        return (int)answer;
    }
}