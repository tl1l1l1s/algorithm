import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        // 트리 형태
        // 송전탑의 개수를 최대한 비슷하게 하되, 하나를 끊어 네트워크를 2개로 분할
        // 개수가 가능한 비슷하도록 두 전력망으로 나눈다
        for(int i=0; i<wires.length; i++) {
            // i = 끊은 선, i를 배제하고 나머지를 돌린다
            int a=1;
            boolean[] visited = new boolean[n+1];
            
            Queue<Integer> q = new ArrayDeque<Integer>();
            q.add(1);
            visited[1] = true;
            
            while(!q.isEmpty()) {
                int curr = q.poll();
                
                for(int j=0; j<wires.length; j++) {
                    if(j==i) continue;
                    
                    if(wires[j][0] == curr) {
                        if(visited[wires[j][1]]) continue;
                        
                        // 방문하지 않은 경우 a++, q에 추가, visited[] true 처리
                        q.add(wires[j][1]);
                        a++;
                        visited[wires[j][1]] = true;
                    }
                    
                    if(wires[j][1] == curr) {
                        if(visited[wires[j][0]]) continue;
                        
                        // 방문하지 않은 경우 a++, q에 추가, visited[] true 처리
                        q.add(wires[j][0]);
                        a++;
                        visited[wires[j][0]] = true;
                    }
                }
            }
            answer = Math.min(Math.abs(2*a - n), answer);
        }
        
        return answer;
    }
}