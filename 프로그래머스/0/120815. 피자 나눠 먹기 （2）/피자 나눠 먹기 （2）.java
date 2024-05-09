class Solution {
    public int solution(int n) {
        int person = n;
        int pizza = 1;

        while(person != pizza * 6){
            if(person > pizza * 6){
                pizza++;
            } else {
                person +=n;
            }
        }
        
        return pizza;
    }
}