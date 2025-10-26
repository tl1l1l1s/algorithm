import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        // 명함 지갑 -> 명함 수납
        // 가로 길이, 세로 길이 충족
        // 모든 명함을 수납할 수 있는 가장 작은 지갑
        int size1 = 0; 
        int size2 = 0;
        
        for(int[] card : sizes) {
            int ma = Math.max(card[0], card[1]);
            int mi = Math.min(card[0], card[1]);
        
            if(size1 < ma) {
                size1 = ma;
            } if(size2 < mi) {
                size2 = mi;
            }
        }
        return size1 * size2;
    }
}