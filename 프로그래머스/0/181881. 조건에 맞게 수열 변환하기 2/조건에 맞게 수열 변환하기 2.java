class Solution {
    public int solution(int[] arr) {
        int i = 0;
        int[] A = arr;
        int[] B = new int[arr.length];
        for(int j= 0; j < B.length; j++){
            B[j] = arr[j];
        }
        B = funx(B);
        
        while(!equalAB(A,B)){
            A = funx(A);
            B = funx(B);
            i++;
        }
        
        return i;
    }
    
    public int[] funx(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int x = arr[i];
            if(x >= 50 && x % 2 == 0){
                arr[i] = x / 2;
            } else if(x < 50 && x % 2== 1){
                arr[i] = x * 2 + 1;
            }
        }
        return arr;
    }
    
    public boolean equalAB(int[] a, int[] b){
        boolean sameLength = false;
        boolean sameContents = false;
        
        if (a.length == b.length){
            sameLength = true;
        } else {
            return false;
        }
        
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        sameContents = true;
        
        return sameContents && sameLength;
    }
}