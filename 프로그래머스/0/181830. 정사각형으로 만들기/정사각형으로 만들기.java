class Solution {
    public int[][] solution(int[][] arr) {
        while(true){
        if(arr.length == arr[0].length){
            return arr;
        } else if(arr.length > arr[0].length){
            arr = plusCol(arr);
        } else{
            arr = plusRow(arr);
        }
        }
    }
    
    public int[][] plusRow(int[][] arr){
        int i = arr.length;
        int j = arr[0].length;
        int[][] res = new int[i + 1][j];
        for(int a = 0; a < i; a++){
            for(int b = 0; b < j; b++){
                res[a][b] = arr[a][b];
            }
        }
        for(int b = 0; b < j; b++){
                res[i][b] = 0;
            }
        
        return res;
    }
    
    public int[][] plusCol(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            int len = arr[i].length;
            int[] temp = new int[len + 1];
            for(int j = 0; j < len;j++ ){
                temp[j] = arr[i][j];
            }
            temp[len] = 0;
            arr[i] = temp;
        }
        return arr;
    }
}