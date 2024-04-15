class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String upper = myString.toUpperCase();
        String UpPat = pat.toUpperCase();
        upper = upper.replace(UpPat, "0");
        if(upper.indexOf("0") != -1){
            System.out.print(upper);
            return 1;
        }
        return 0;
    }
}