import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // queue -> FIFO
        // ㅂ stack -> LIFO
        Queue<Character> q = new ArrayDeque<Character>();
        
        for(int i=0; i<s.length(); i++) {
            char x = s.charAt(i);
            
            if(x == '(') {
                q.offer('(');
            } else if(x == ')') {
                if(q.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    q.poll();
                }
            }
        }
        
        if(!q.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}