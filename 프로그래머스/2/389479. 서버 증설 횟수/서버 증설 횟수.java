import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // m명 미만 -> 증설 X
        // n*m 이상, (n+1)*m 미만 이면 n대 운영 필요
        // k 시간동안 운영, 그 이후에는 반납
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        int current = m-1;
        
        for(int p=0; p<players.length; p++) {
            // 증설된 서버가 있다면 해당 서버를 반납해야 하는지 확인
            for(int s=index; s<list.size(); s++) {
                if(list.get(s) == p) { // 서버 반납해야 하는 경우
                    current -= m;
                }

                if(list.get(s) > p) {
                    index = s; // 다음 index 갱신, 여기부터 조회할 것
                    break;
                }
            }
            
            if(players[p] > current) { // 서버 증설이 필요한 경우
                int count = (players[p] - current) / m;
                if((players[p] - current) % m > 0) count++;
                
                answer += count;
                for(int c=0; c<count; c++) {
                    current += m;
                    list.add(p + k);   
                }
            }
        }
        
        return answer;
    }
}