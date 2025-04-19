import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] status = new int[n+1];
        Arrays.fill(status, 1);
        for(int i=0; i<lost.length; i++) {
            status[lost[i]]--;
        }
        for(int i=0; i<reserve.length; i++) {
            status[reserve[i]]++;
        }
        
        for(int i=1; i<status.length; i++) {
            if(status[i] == 1) {
                answer++;
            } else if(status[i] > 1) {
                answer++;
                if(i-1 >= 1 && status[i-1] < 1) {
                    status[i-1] = 1;
                    answer++;
                } else if(i+1 < status.length && status[i+1] < 1) {
                    status[i+1] = 1;
                }
            }
        }
        return answer;
    }
}