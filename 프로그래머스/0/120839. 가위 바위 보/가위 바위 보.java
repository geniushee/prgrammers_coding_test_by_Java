class Solution {
    public String solution(String rsp) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] rsps = rsp.split("");
        for(String s : rsps){
            if(s.equals("2")){
                sb.append("0");
            } else if(s.equals("0")){
                sb.append("5");
            } else {
                sb.append("2");
            }
        }
        return sb.toString();
    }
}