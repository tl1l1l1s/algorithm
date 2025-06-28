import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        
        for(int i=0; i<answer.length; i++) {
            long num = begin + i;
            
            for(long j=2; j<=Math.sqrt(num); j++) {
                if(num % j == 0) {
                    if(num / j > 10000000) {
                        answer[i] = (int)j;
                        continue;
                    } else {
                        answer[i] = (int) (num/j);
                    }
                    break;
                }
            }
            
            if(answer[i] == 0) {
                answer[i] = 1;
            }
        }
        
        if(begin == 1) answer[0] = 0;
        return answer;
    }
}