import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int can = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int size = set.size();
        if(can > size){
            return size;
        }else{
        return can;
        }
    }
}