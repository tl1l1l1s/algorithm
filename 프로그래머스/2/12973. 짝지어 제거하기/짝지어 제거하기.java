import java.util.*;

class Solution
{
    public int solution(String s)
    {

        // 스트링들 보다가 앞뒤로 중복되는 알파벳 문자열 있으면 제거
        // 이후 제거된 문자열 앞뒤만 확인하면 됨
        
        Deque<Character> stack = new ArrayDeque<Character>();
        
        for(int i=0; i<s.length(); i++) {
            if(stack.size() == 0) {
                stack.push(s.charAt(i));
            } else {
                if(stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else stack.push(s.charAt(i));
            }
        }
        
        
        return stack.size() == 0 ? 1 : 0;
    }
}