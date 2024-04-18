class Solution {
    public String solution(String myString, String pat) {
        int len = pat.length();
        for(int max = myString.length(); max - len > 0; max--){
            String temp = myString.substring((max - len), max);
            // System.out.println("max : " + max + "/ temp : " + temp);
            if(temp.equals(pat)){
                return myString.substring(0,max);
            }
        }
        
        return pat;
    }
}