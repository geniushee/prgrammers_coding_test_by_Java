class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String word : dic){
            for(int i =0; i< spell.length; i++){
                if(!word.contains(spell[i])){
                    break;
                } else if(i == spell.length -1){
                    return 1;
                }
            }
        }
        return 2;
    }
}