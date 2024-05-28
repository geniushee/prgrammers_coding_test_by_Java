class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char s : arr){
            if(Character.isUpperCase(s)){
                s = Character.toLowerCase(s);
                sb.append(s);
            }else{
                s = Character.toUpperCase(s);
                sb.append(s);
            }
        }
        return sb.toString();
    }
}