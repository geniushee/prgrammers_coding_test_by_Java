class Solution {
    public int solution(int n) {
        int res = n;
        for(int i = 3; i <= n; i++){
            if(check(i)){
                res++;
            }
            System.out.println("i : "+i+", check : " + res);
            while(check(res)){
                res++;
            }
            System.out.println("3x : " + res);
        }
        
        return res;
    }
    
    boolean check(int i){
        if(i % 3==0){
                return true;
            } else{
                for(String s : String.valueOf(i).split("")){
                    if(s.equals("3")){
                        return true;
                    }
                }
            }
        return false;
    }
}