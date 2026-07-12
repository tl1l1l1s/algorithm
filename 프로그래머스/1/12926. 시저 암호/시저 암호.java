import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            
            if(curr == ' ') {
                sb.append(curr);
            } else {
                int a = curr + n;
            
                if(a > 'z') {
                    sb.append((char) (a - ('z' - 'a' + 1)));
                } 
                else if(a >= 'a') {
                    if(curr <= 'Z') {
                        sb.append((char) (a - 'Z' + 'A' - 1));
                    } else sb.append((char) a);
                } else if (a > 'Z') {
                    sb.append((char) (a - ('Z' - 'A' + 1)));
                } else {
                    sb.append((char) a);
                }
            }
            
        }
        return sb.toString();
    }
}