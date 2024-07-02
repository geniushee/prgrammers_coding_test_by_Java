import java.util.*;
class Solution {
    public int solution(int len, int weight, int[] truck_weights) {
        int clock = 0;
        int complete = 0;
        int[] bridge = new int[len];
        int end = len - 1;
        int order = 0;
        
        while(true){
            clock++;//시간 1초 경과
            bridge = move(bridge); //한칸씩 움직임
            
            int check = sum(bridge);
            int next = 0;
            
            if(order < truck_weights.length){
            next = truck_weights[order];
            }
            if(check <= weight){
                if(check + next <= weight && order < truck_weights.length){
                    bridge[end] = next; // 다리위의 총합과 추가로 들어오는 차량 무게가 기준이하
                    order++;
                    check += next;
                }
            }
            // System.out.println("시간 : " + clock + ", 다리 현황 : " + Arrays.toString(bridge) + ", 순번 : " + order);
            if(check == 0 && order == truck_weights.length){
                break;
            }
        }
        return clock;
    }
    
    public int[] move(int[] arr){
        for(int i = 1; i < arr.length; i++){
            arr[i -1] = arr[i];
        }
        arr[arr.length - 1] = 0;
        return arr;
    }
    
    public int sum(int[] arr){
        int sum = 0;
        for(int a : arr){
            sum += a;
        }
        return sum;
    }
}