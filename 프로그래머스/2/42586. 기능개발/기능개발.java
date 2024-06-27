import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        List<Integer> prg = Arrays.stream(progresses).mapToObj(i ->(Integer) i).collect(Collectors.toList());
        List<Integer> spd = Arrays.stream(speeds).mapToObj(i ->(Integer) i).collect(Collectors.toList());
        
        while(prg.size() > 0){
            for(int i = 0; i < spd.size(); i++){
                prg.set(i, prg.get(i) + spd.get(i));
            }
            Integer e = 0;
            while(prg.size() > 0 && prg.get(0) >= 100){
                prg.remove(0);
                spd.remove(0);
                e++;
            }
            if(e != 0){
                answerList.add(e);
            }
            
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}