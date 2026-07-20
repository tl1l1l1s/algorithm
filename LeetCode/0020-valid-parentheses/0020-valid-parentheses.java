import java.util.*;

class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> adq = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++) {
            Character curr = s.charAt(i);

            if(curr == ')') {
                if(adq.size() > 0 && adq.peek() == '(') adq.pop();
                else return false;
            } else if(curr == '}') {
                if(adq.size() > 0 && adq.peek() == '{') adq.pop();
                else return false;
            } else if(curr == ']') {
                if(adq.size() > 0 && adq.peek() == '[') adq.pop();
                else return false;
            } else adq.offerFirst(curr);
        }

        return adq.size() == 0 ? true : false;
    }
}