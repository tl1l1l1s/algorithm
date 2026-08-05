import java.util.*;

class Solution {
    
    public int getDistance(int now, int dist) {
        int currentRow = now%3 == 0 ? now/3 - 1 : now/3;
        int currentCol = now%3 == 0 ? 3 : now%3;
        int distRow = dist%3 == 0 ? dist/3 -1 : dist/3;
        int distCol = dist%3 == 0 ? 3 : dist%3;
        
        if(now == -1) {
            currentRow = 3;
            currentCol = 1;
        } else if(now == -2) {
            currentRow = 3;
            currentCol = 3;
        } else if(now == 0) {
            currentRow = 3;
            currentCol = 2;
        }
        if(dist == 0) {
            distRow = 3;
            distCol = 2;
        }
        
        return Math.abs(distRow - currentRow) + Math.abs(distCol - currentCol);
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int L = -1; int R = -2;
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                L = numbers[i];
                sb.append("L");
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                R = numbers[i];
                sb.append("R");
            } else {
                int nL = getDistance(L, numbers[i]);
                int nR = getDistance(R, numbers[i]);
                
                if(nL < nR) {
                    L = numbers[i];
                    sb.append("L");
                } else if(nL > nR) {
                    R = numbers[i];
                    sb.append("R");
                } else {
                    if(hand.equals("left")) {
                        L = numbers[i];
                        sb.append("L");
                    } else {
                        R = numbers[i];
                        sb.append("R");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}