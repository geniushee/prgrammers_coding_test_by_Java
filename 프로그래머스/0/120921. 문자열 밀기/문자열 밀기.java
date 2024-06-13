class Solution {
    public int solution(String A, String B) {
        System.out.println(push(A));
        if(A.equals(B)){
                return 0;
            }
        for(int i = 1; i < A.length();i++){
            A = push(A);
            if(A.equals(B)){
                return i;
            }
        }
        return -1;
    }
    
    public String push(String a){
        String f = a.substring(0, a.length() - 1);
        String b = a.substring(a.length() - 1);
        return b + f;
    }
}