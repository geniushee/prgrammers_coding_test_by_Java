import java.util.*;
class Dqueue{
    private int[] heap;
    private int size;
    private int capacity;
    
    public Dqueue(int initCapa){
        this.heap = new int[initCapa + 1];
        this.size = 0;
        this.capacity = initCapa;
    }
    
    private int parent(int idx){
        return idx / 2;
    }
    private int leftChild(int idx){
        return idx * 2;
    }
    private int rightChild(int idx){
        return idx * 2 + 1;
    }
    
    public void ensureCapa(){
        if(size >= capacity){
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity + 1);
            
        }
    }
    
    public void add(int element){
        ensureCapa();
        heap[++size] = element;
    }
    
    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    
    private void maxSort(){
        int originSize = size;
        for(int i = size; i > 1; i--){
            maxUp(i);
        }
    }
    
    private void maxUp(int idx){
        int current = idx;
        while(current > 1){
            if(heap[current] > heap[parent(current)]){
                swap(current, parent(current));
                current = parent(current);
            } else{
                return;
            }
        }
    }
    
    private void minSort(){
        int originSize = size;
        for(int i = size; i > 1; i--){
            minUp(i);
        }
    }
    
    private void minUp(int idx){
        int current = idx;
        while(current > 1){
            if(heap[current] < heap[parent(current)]){
                swap(current, parent(current));
                current = parent(current);
            } else{
                return;
            }
        }
    }
    
    public int getMin(){
        if(size == 0){
            return 0;
        }
        minSort();
        int min = heap[1];
        heap[1] = heap[size--];
        return min;
    }
    
    public int getMax(){
        if(size == 0){
            return 0;
        }
        maxSort();
        int max = heap[1];
        heap[1] = heap[size--];
        return max;
    }
    
    public int[] getHeap(){
        if(size == 0){
            return new int[0];
        }
        return Arrays.copyOfRange(heap,1,size+1);
    }
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Dqueue q = new Dqueue(1);
        for(String op : operations){
            switch (op.substring(0,1)){
                case "I" : q.add((int) Integer.valueOf(op.substring(2))); break;
                case "D" : if(op.substring(2).equals("1")){
                    int a = q.getMax();
                    // System.out.println(a);
                }else{
                    int b = q.getMin();
                    // System.out.println(b);
                }
            }
        }
        answer[0] = q.getMax();
        answer[1] = q.getMin();
        return answer;
    }
}