import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] routes;
	static int[][] dp;
	
	static final int INF = 16_000_001;
	
	static int tsp(int currentCity, int visitBitmask) {
		if(visitBitmask == (1 << N) - 1) {
			if(routes[currentCity][0] == 0) {
				return INF;
			}
			
			return routes[currentCity][0];
		}
		
		if(dp[currentCity][visitBitmask] != -1) {
			return dp[currentCity][visitBitmask];
		}
		
		dp[currentCity][visitBitmask] = INF;
		for(int i = 0; i<N; i++) {
			if((visitBitmask & (1 << i)) == 0 // i번째 도시 방문 여부 체크
					&& routes[currentCity][i] != 0) { // 현 도시 -> i번째 도시 갈 수 있는지 확인
				dp[currentCity][visitBitmask] = Math.min(dp[currentCity][visitBitmask],
						tsp(i, visitBitmask | (1 << i)) + routes[currentCity][i]); // 현재 dp와 i번째 도시를 방문한 것으로 업데이트한 tsp와 비교
			}
		}
		return dp[currentCity][visitBitmask];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		routes = new int[N][N];
		dp = new int[N][(1 << N)];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				routes[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}
		
		bw.write(String.valueOf(tsp(0, 1)));
		bw.flush();
		bw.close();
		br.close();

	}

}