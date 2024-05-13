class Solution {
    public String solution(String my_string) {
        int len = my_string.length();
        char[] chararray = my_string.toCharArray();
        
        StringBuilder strb = new StringBuilder();
        for(int i = 0; i < chararray.length; i++){
            strb.append(chararray[len - 1 -i]);
        }
        return strb.toString();
    }
}