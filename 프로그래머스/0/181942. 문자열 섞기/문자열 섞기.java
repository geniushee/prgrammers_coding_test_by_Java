class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < (Math.max(str1.length(), str2.length())); i++){
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }
        return sb.toString();
    }
}