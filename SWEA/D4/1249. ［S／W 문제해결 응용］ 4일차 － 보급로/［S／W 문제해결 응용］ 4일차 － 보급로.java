import java.io.*;
import java.util.*;

class Solution {
	static int N;
	static final int[][] drc = {
			{-1, 0}, {1, 0},
			{0, -1}, {0, 1}
	};
	static int[][] road; // 해당 칸의 복구 시간
	static int[][] dp; // 검증된 최소 복구 시간
	
	static class Road implements Comparable<Road> {
		int x;
		int y;
		int cost; // 누적 복구 시간
		
		Road(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.cost = c;
		}
		
		@Override
		public int compareTo(Road o) {
			return this.cost - o.cost;
		}
	}
	
	static void solution() {
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		pq.offer(new Road(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Road curr = pq.poll();
			
			if(curr.cost > dp[curr.x][curr.y]) continue;
			
			for(int i=0; i<4; i++) {
				int nx = curr.x + drc[i][0];
				int ny = curr.y + drc[i][1];
				
				if(nx >= 0 && nx < N &&
						ny >= 0 && ny < N) {
					int temp = curr.cost + road[nx][ny];
					if(dp[nx][ny] > temp) {
						dp[nx][ny] = temp;
						pq.offer(new Road(nx, ny, dp[nx][ny]));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// S -> G 도로 복구 작업을 빠르게 수행
		// 깊이에 비례해 복구 시간은 증가
		// 가장 복구 시간이 짧은 경로에 대해 총 복구 시간을 구함
		// 깊이 = 1, 복구 시간 = 1
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			road = new int[N][N];
			dp = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					road[i][j] = Integer.valueOf(str.charAt(j)) - '0';
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
            dp[0][0] = 0;
            
			solution();
			System.out.println("#" + tc + " " + dp[N-1][N-1]);
		}
		br.close();
	}
}