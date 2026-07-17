import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        StringBuilder sb;
        
        while(!s.equals("1")) {
            answer[0] += 1;
            sb = new StringBuilder();
            int ones = 0;
            int temp = 0;
            
            // 0을 제거하고 arrayList에 0을 몇 개 제거했는지 저장
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                
                if(c == '0') {
                    temp++;
                } else ones++;
            }
            answer[1] = answer[1] + temp;
            
            // 0을 제거한 이후 자릿수를 이진법 변환
            sb = new StringBuilder();
            while(ones >= 2) {
                sb.append(ones % 2);
                ones /= 2;
            }
            sb.append(ones % 2);
            
            s = sb.reverse().toString();
        }
        
        return answer;
    }
}