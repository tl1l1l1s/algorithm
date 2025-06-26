// 푸드 파이터 대회
// 왼쪽 -> 오른쪽으로, 오른쪽 -> 왼쪽
    // 가운데 물을 먼저 먹는 선수가 승리
// 칼로리가 낮은 음식..?뭐?
import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++) {
                sb.append(i);
            }
        }
        
        answer += sb.toString();
        answer += "0";
        answer += sb.reverse().toString();
        
        return answer;
    }
}