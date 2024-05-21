class Solution {
    public int solution(int[] numbers, int k) {
        int c = 1;
        int i = 0;
        while(c < k){
            System.out.println((c + 1) + " : " + i);
            i+=2;
            i%=numbers.length;
            c++;     
        }
        return numbers[i];
    }
}