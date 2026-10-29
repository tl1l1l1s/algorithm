import java.util.*;
class Solution {
    
    static HashMap<String, Integer> count;
    
    public void getAllCombinations(String s, int n, int idx, char[] total) {
        if(s.length() == n) {
            count.put(s, count.getOrDefault(s, 0) + 1);
            return;
        }
        
        // idx = 현재 total(원문자열) 중 어디까지 입력했는가
        // n = 조합 개수
        
        for(int i=idx; i<total.length; i++) {
            getAllCombinations(s + total[i], n, i + 1, total);
        }
        return;
    }
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> temp;
        
        for(int cn: course) {
            count = new HashMap<>();
            temp = new ArrayList<>();
            
            for(int i=0; i<orders.length; i++) {
                if(orders[i].length() < cn) continue;
                
                char[] total = orders[i].toCharArray();
                Arrays.sort(total);
                getAllCombinations("", cn, 0, total);
            }
            
            int max = 2;
            
            for(Map.Entry<String, Integer> entry: count.entrySet()) {
                if(max < entry.getValue()) {
                    max = entry.getValue();
                    temp = new ArrayList<>();
                    temp.add(entry.getKey());
                } else if(max == entry.getValue()) {
                    temp.add(entry.getKey());
                }
            }
            
            for(int i=0; i<temp.size(); i++) {
                answer.add(temp.get(i));
            }
        }
        
        Collections.sort(answer); // 오름차순 정렬
        return answer.toArray(new String[answer.size()]);
    }
}