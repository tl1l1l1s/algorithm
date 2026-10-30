import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] sums = new int[board.length][board[0].length];
        
        for(int i=0; i<sums.length; i++) {
            Arrays.fill(sums[i], 0);
        }
        
        for(int i=0; i<skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = (type == 1) ? skill[i][5] * -1 : skill[i][5];
            
            sums[r1][c1] = sums[r1][c1] + degree;
            if(r2 + 1 < board.length) {
                sums[r2 + 1][c1] = sums[r2 + 1][c1] - degree;
            }
            
            if(c2 + 1 < board[0].length) {
                sums[r1][c2 + 1] = sums[r1][c2 + 1] - degree;
                    
                if(r2 + 1 < board.length) {
                    sums[r2 + 1][c2 + 1] = sums[r2 + 1][c2 + 1] + degree;
                }  
            }
        }
        
        int count = 0;
        for(int r=0; r<board.length; r++) {
            count = 0;
            for(int c=0; c<board[0].length; c++) {
                count += sums[r][c];
                sums[r][c] = count;
            }
        }
        
        for(int c=0; c<board[0].length; c++) {
            count = 0;
            for(int r=0; r<board.length; r++) {
                sums[r][c] += count;
                count = sums[r][c];
                
                board[r][c] += sums[r][c];
                if(board[r][c] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}