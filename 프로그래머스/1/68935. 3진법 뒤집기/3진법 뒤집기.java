import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(n >= 3) {
            sb.append(n % 3);
            n /= 3;
        }
        sb.append(n % 3);
        
        String newS = sb.reverse().toString();
        for(int i=0; i<newS.length(); i++) {
            answer += Math.pow(3, i) * (int)(newS.charAt(i) - '0');
        }
        
        return answer;
    }
}