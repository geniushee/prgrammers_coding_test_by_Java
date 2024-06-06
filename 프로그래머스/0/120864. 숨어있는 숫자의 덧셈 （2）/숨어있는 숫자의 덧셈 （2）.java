class Solution {
    public int solution(String my_string) {
        int answer = 0;
        // System.out.println(my_string.replaceAll("[a-zA-Z]+"," ").trim());
        String[] numbers = my_string.replaceAll("[a-zA-Z+]"," ").trim().split(" ");
        for(String num : numbers){
            if(num.isBlank()){
                continue;
            }
            answer+=(int) Integer.valueOf(num);
        }
        return answer;
    }
}