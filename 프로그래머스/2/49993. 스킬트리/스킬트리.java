import java.util.*;
class Solution {
    static Boolean[] canLearn;
    
    private void initialize() {
        Arrays.fill(canLearn, false);
        canLearn[0] = true;
    }
    
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        canLearn = new Boolean[skill.length()]; // 해당 index의 스킬을 현재 배울 수 있는지
        
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<skill.length(); i++) {
            hm.put(skill.charAt(i), i);
        }
        
        for(String s : skill_trees) {
            initialize();
            for(char c : s.toCharArray()) {
                if(hm.get(c) != null) {
                    int idx = hm.get(c);
                    if(canLearn[idx]) {
                        if(idx+1 < hm.size()) {
                            canLearn[idx + 1] = true;
                        }
                    } else {
                        answer--;
                        break;
                    }
                }
            }
        }
        
        
        
        return answer;
    }
}