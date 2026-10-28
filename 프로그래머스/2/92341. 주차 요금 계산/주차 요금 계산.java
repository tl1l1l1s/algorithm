import java.util.*;

class Solution {
    
    private int calculateMinutes(int ih, int im, int oh, int om) {
        int hourGap = oh - ih;
        int minGap = om - im;
        
        if(minGap < 0) {
            hourGap --;
            minGap += 60;
        }
        
        return (hourGap * 60) + minGap;
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        // 입차 후 출차 기록 X -> 23:59 출차
        
        // 차량번호를 기반으로 찾는다
            // 출차 시 해당 차량번호를 기준으로 
        
        // 저장 해야 하는 것
            // 차량 번호 + 총 주차 시간이 얼마나 됐는지
        
        HashMap<String, String> hmap = new HashMap<>();
        SortedMap<Integer, Integer> answer = new TreeMap<>((s1, s2) -> s1 - s2);
        
        for(int i=0; i<records.length; i++) {
            String[] record = records[i].split(" ");
            
            if(record[2].equals("IN")) {
                hmap.put(record[1], record[0]);
            } else { // 출차
                String[] time = hmap.get(record[1]).split(":");
                int inHr = Integer.valueOf(time[0]);
                int inMin = Integer.valueOf(time[1]);
                
                // 출차 시간
                String[] currentTime = record[0].split(":");
                int outHr = Integer.valueOf(currentTime[0]);
                int outMin = Integer.valueOf(currentTime[1]);
                
                int mins = calculateMinutes(inHr, inMin, outHr, outMin);
            
                answer.put(Integer.valueOf(record[1]), 
                           answer.getOrDefault(Integer.valueOf(record[1]), 0) + mins);
                hmap.remove(record[1]);
            }
        }
        
        // 23:59 출차 처리
        if(!hmap.isEmpty()) {
            hmap.forEach((key, value) -> {
                String[] time = value.split(":");
                int mins = calculateMinutes(Integer.valueOf(time[0]), 
                                            Integer.valueOf(time[1]), 23, 59);
            
                answer.put(Integer.valueOf(key), 
                           answer.getOrDefault(Integer.valueOf(key), 0) + mins);
            });
                
        }
        
        answer.forEach((key, value) -> {
            if(value >= fees[0]) {
                    answer.put(Integer.valueOf(key), 
                               fees[1] 
                               + (int) (Math.ceil((value - fees[0]) / (double) fees[2])) * fees[3]);
            } else {
                answer.put(Integer.valueOf(key), fees[1]);
            }
        });
        
        return answer.values().stream().mapToInt(Integer::intValue).toArray();
    }
}