import java.util.*;
class Solution {
    public int solution(int[] array, int height) {
        Arrays.sort(array);
        
        int low = 0;
        int high = array.length;
        
        while(high>low) {
            int current = (high + low) / 2;
            
            if(array[current] > height) {
                high = current;
            } else {
                low = current + 1;
            }
        }
        return array.length - low;
    }
}