class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int c = 0;
        // System.out.println(polynomial.replaceAll("[ ][+]",""));
        String[] arr = polynomial.replaceAll("[ ][+]","").split(" ");
        for(String s : arr){
            if(s.contains("x")){
                if(s.length() == 1){
                    x++;
                    continue;
                }
                x += Integer.valueOf(s.replace("x",""));
            }else{
                c += Integer.valueOf(s);
            }
        }
        
        if(x != 0 && c != 0){
            if(x == 1){
                    return "x + " + c;
                }
            return x + "x + " + c;
        } else if(x ==0){
            return String.valueOf(c);
        } else {
            if(x == 1){
                    return "x";
                }
            return x + "x";
        }
        
    }
}