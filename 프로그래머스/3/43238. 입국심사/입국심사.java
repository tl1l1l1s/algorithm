import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 입국심사 대기자 수 n
        // 심사관이 한 명을 심사하는데 걸리는 시간 배열 times
        // 입국심사를 다 받기까지 걸리는 최소 시간
        Arrays.sort(times);
        
        long left = times[0];
        long right = times[0] * (long) n;
        long mid = (left + right) / 2;
        
        while(left <= right) {
            
            long count = 0; // 현재 mid 시간을 기준으로 처리할 수 있는 대기자 수
            for(int time: times) {
                count += mid / time;
            }
            
            if(count >= n) {
                answer = mid;
               right = mid - 1; 
            } else {
                left = mid + 1;
            }
            
            mid = (left + right) / 2;
        }
        
        return answer;
    }
}