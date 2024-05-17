class Solution {
    public String solution(int age) {
        char[] ages = {'a', 'b','c','d','e','f','g','h','i','j'};
        String sAge = String.valueOf(age);
        StringBuilder strb = new StringBuilder();
        for(char c : sAge.toCharArray()){
            int n = (int) Integer.valueOf(c) - 48;
            // System.out.println(c);System.out.println(n);
            
            strb.append(ages[n]);
        }
        
        String answer = strb.toString();
        return answer;
    }
}