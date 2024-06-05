class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] an = new int[2];
        int bymax = board[1] / 2;
        int bxmax = board[0] / 2;
        for(String key : keyinput){
            switch (key){
            case "up" : if(an[1] != bymax){an[1]++;} break;
                case "down" : if(an[1] != -bymax){an[1]--;} break;
                case "left" : if(an[0] != -bxmax){an[0]--;} break;
                case "right" : if(an[0] != bxmax){an[0]++;} break;
                    
        }
        }
        
        
        return an;
    }
}