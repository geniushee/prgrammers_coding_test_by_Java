import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int i = 0;
        int j = 0;
        int cycle = 0;
        int val = 1;
        String[] dirs = {"r", "d", "l", "u"};
        String dir = dirs[0];
        while(val <= n * n){
        switch (dir){
            case "r": answer[i][j] = val; val++; j++; if(j + cycle == answer[i].length - 1){ dir = dirs[1];} break;
            case "d" : answer[i][j] = val; val++; i++; if(i + cycle == answer.length - 1){dir = dirs[2];} break;
            case "l" : answer[i][j] = val; val++; j--; if(j - cycle == 0){dir = dirs[3]; cycle++;} break;
            case "u" : answer[i][j] = val; val++; i--; if(i - cycle == 0){dir = dirs[0];} break;
        }

        }
        return answer;
    }
}