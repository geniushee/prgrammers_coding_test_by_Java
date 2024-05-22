import java.util.*;
import java.util.Collections;

class Solution {
    public int solution(int[] numbers) {
        numbers = sortR(numbers);
        // for(int a : numbers){
        //     System.out.println(a);
        // }
        return numbers[0] * numbers[1];
    }
    
    public int[] sortR(int[] arr){
        boolean s = true;
        while(s){
            for(int i = 1; i < arr.length; i++){
                if(arr[i] - arr[i-1] > 0){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    break;
                }
                if(i == arr.length -1){
                    s = false;
                }
            }
        }
        return arr;
    }
}