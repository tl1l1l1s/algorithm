import java.util.*;

class Solution {
    
    static int[][] drc = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int tx = maps.length;
        int ty = maps[0].length;
        
        int[][] dist = new int[tx][ty];
        for(int i=0; i<tx; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            
            if(x == tx - 1 && y == ty -1) return dist[x][y];
            
            for(int i=0; i<4; i++) {
                int cx = x + drc[i][0];
                int cy = y + drc[i][1];
                
                if(cx < 0 || cy < 0 || cx >= tx || cy >= ty) continue;
                if(maps[cx][cy] == 0 || dist[cx][cy] != -1) continue;
                
                dist[cx][cy] = dist[x][y] + 1;
                q.offer(new int[]{cx, cy});
            }
            
        }
        
        return -1;
    }
}