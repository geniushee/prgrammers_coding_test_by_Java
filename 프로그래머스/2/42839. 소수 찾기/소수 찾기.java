import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    List<Integer> idxs = new ArrayList();
    
    public int solution(String numbers) {
        int answer = 0;
        String[] nums = numbers.split("");
        int len = nums.length;
        String initString = "";
        // 모든 가능한 수 set에 넣기
        createSet(nums, len, initString.length(), initString);
        
        System.out.println(set);
        
        for(Integer i : set){
            if(isPrime(i)){
                answer++;
            }
        }
        
        return answer;
    }
    
    // 빈set 전역 변수 사용, 빈 string 초기 주입, 빈 list 전역변수 사용
    public void createSet(String[] nums, int arrLength, int curLength, String curString){
        if(curLength == arrLength){
            return;
        }
        
        for(int i =0; i < arrLength; i++){
            String temp = curString;
            if(idxs.contains(i)){
                continue;
            }
            idxs.add(i);
            curString += nums[i];
            // System.out.println("현재 길이: "+curString.length()+", 현재 글자:" +curString);
            set.add(Integer.valueOf(curString));
            if(curString.length() != arrLength){
                createSet(nums, arrLength, curString.length(), curString);
            }
            idxs.remove(Integer.valueOf(i));
            curString = temp;
        }
    }
    
    public boolean isPrime(int num){
        for(int i =2; i*i <= num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return num <= 1 ? false : true;
    }
}