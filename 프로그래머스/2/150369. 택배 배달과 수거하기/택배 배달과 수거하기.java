class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 일렬로 나열된 n개의 집에 택배 전달
            // i번째 집은 거리 i만큼 떨어짐
            // j번째 집 <-> i반쩨 집의 거리: j-i
        // 택배 상자 최대 cap개
            // 배달 + 빈 상자 수거 해서 귀환
        // 트럭 하나만 사용, 최소 거리로 이동
        
        int dNxt = deliveries.length - 1;
        int pNxt = pickups.length - 1; 
        
        while(true) {
            while (dNxt >= 0 && deliveries[dNxt] == 0) dNxt--;
            while (pNxt >= 0 && pickups[pNxt] == 0) pNxt--;

            if (dNxt == -1 && pNxt == -1) break;
            
            int dTemp = cap;
            int pTemp = cap;
            
            answer += (Math.max(dNxt, pNxt) + 1) * 2;

            while (dNxt >= 0 && dTemp > 0) {
                int count = Math.min(dTemp, deliveries[dNxt]);
                deliveries[dNxt] -= count;
                dTemp -= count;
                
                if (deliveries[dNxt] == 0) {
                    dNxt--;
                }
            }

            while (pNxt >= 0 && pTemp > 0) {
                int count = Math.min(pTemp, pickups[pNxt]);
                pickups[pNxt] -= count;
                pTemp -= count;

                if (pickups[pNxt] == 0) {
                    pNxt--;
                }
            }
            
        }
        
        return answer;
    }
}