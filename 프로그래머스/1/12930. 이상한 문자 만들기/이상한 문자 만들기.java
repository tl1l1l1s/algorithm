import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int j = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                j = 0;
                sb.append(' ');
                continue;
            } else {
                if(j == 0 || j % 2 == 0) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else sb.append(Character.toLowerCase(s.charAt(i)));
            }
            
            j++;
        }
        return sb.toString();
    }
}