import java.util.*;
class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{numbers[0], 0});
        dq.offer(new int[]{0-numbers[0], 0});
        
        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int currentTotal = current[0];
            int currentIndex = current[1];
            
            if(currentIndex == numbers.length-1) {
                if(currentTotal == target) {
                    answer++; 
                }
                continue;
            }
            
            int nextIndex = currentIndex + 1;
            dq.offer(new int[]{currentTotal + numbers[nextIndex], nextIndex});
            dq.offer(new int[]{currentTotal - numbers[nextIndex], nextIndex});
        }
        
        return answer;
    }
}