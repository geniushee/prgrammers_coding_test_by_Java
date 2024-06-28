class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int[] lr = new int[]{0,0};
        boolean start = true;
        
        String[] arr = s.split("");
        for(String e : arr){
            if(start && e.equals(")")){
                return false;
            } else{
                start = false;
            }
            
            if(e.equals("(")){
                lr[0]++;
            } else {
                lr[1]++;
            }
            
            if(lr[0] == lr[1]){
                start = true;
                lr[0] = 0;
                lr[1] = 0;
            }
        }
        
        if(lr[0] == lr[1]){
                return true;
            }
        
        return false;
    }
}