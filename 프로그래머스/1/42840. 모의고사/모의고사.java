import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int s1Cnt = 0;
        int s2Cnt = 0;
        int s3Cnt = 0;
        
        for(int i=0; i<answers.length; i++) {
            if(s1[i%5] == answers[i]) {
                s1Cnt++;
            }
            
            if(s2[i%8] == answers[i]) {
                s2Cnt++;
            }
            
            if(s3[i%10] == answers[i]) {
                s3Cnt++;
            }
        }
        
        List<Integer> students = new ArrayList<>();
        int max = Math.max(s1Cnt, Math.max(s2Cnt, s3Cnt));
        if(s1Cnt == max) {
            students.add(1);
        }
        if(s2Cnt == max) {
            students.add(2);
        }
        if(s3Cnt == max) {
            students.add(3);
        }
        
        return students.stream().mapToInt(Integer::intValue).toArray();
    }
}