class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        if(arr1.length == arr2.length){
            return compare1(arr1, arr2);
        }
        
        return arr1.length > arr2.length ? 1 : -1;
    }
    
    public int compare1(int[] arr1, int[] arr2){
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr1.length; i++){
            sum1 = sum1 + arr1[i];
            sum2 = sum2 + arr2[i];
            // System.out.println("sum1 : " + sum1 + " / sum2 : " + sum2);
        }
        return sum1 > sum2 ? 1 : (sum1 == sum2 ? 0 : -1);
    }
    
}