import java.util.*;
class Solution {
    public String[] solution(String[] names) {
        List<String> answer = new ArrayList<>();
        
        int i = 0;
        while(i < names.length) {
            answer.add(names[i]);
            i+=5;
        }
        
        return answer.toArray(new String[0]);
    }
}