class Solution {
    public int solution(int price) {                
        if(price >= 500000){
            return (int) (0.8 * price);
        } else if(price >= 300000){
            return (int) (0.9 * price);
        } else if(price >= 100000){
            return (int) (0.95 * price);
        }
        return price;
    }
}