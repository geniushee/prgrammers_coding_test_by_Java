import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int[] arr = {-1,0,1};
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    for(int a : arr){
                        int n = i + a;
                        if(n >= 0 && board.length > n){
                            for(int b : arr){
                                int m = j + b;
                                if(m >= 0 && board[i].length > m){
                                    if(board[n][m] == 1){
                                        continue;
                                    }
                                    board[n][m] = 2;
                                }
                            }
                        }
                    }
                    
                }
                // for(int[] bbite : board){
                // System.out.print(Arrays.toString(bbite));
                //                    }
                // System.out.println("");
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] ==0){
                    answer++;
                }
            }
        }
        return answer;
    }
}