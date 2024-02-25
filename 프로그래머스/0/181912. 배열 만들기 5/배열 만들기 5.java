class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        for(String intStr : intStrs){
            int i = changeInt(intStr, s, l);
            if(i > k) answer = addItem(answer, i);        }
        return answer;
    }
    
    public int[] addItem(int[] arr, int item){
        int[] re = new int[arr.length + 1];
        for (int i = 0; i < arr.length ; i++){
            re[i] = arr[i];
        }
        re[arr.length] = item;
        return re;
    }
    
    public int changeInt(String intStr, int s, int l){
        String str = intStr.substring(s,s + l);
        int i = Integer.parseInt(str);
        return i;
    }
}