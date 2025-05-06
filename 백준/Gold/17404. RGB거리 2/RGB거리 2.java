import java.io.*;
import java.util.*;

public class Main {
	static final int limit = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// RGB 거리에는 집이 1~N개 존재
		
		// 1 != 2 != N
		// N != N-1 != 1
		// X != X-1 != X+1
		
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken()); // R
			cost[i][1] = Integer.parseInt(st.nextToken()); // G
			cost[i][2] = Integer.parseInt(st.nextToken()); // B
		}
		
		long[][] dp = new long[N+1][3];
		for(int i=0; i<3; i++) {
			dp[1][i] = cost[1][i];
		}
		
		// 3가지로 나눠서 dp[1] = R, G, B일 때를 나눠서 구한다.
		// 1 = R(0)
		long result = Integer.MAX_VALUE;
		dp[1][1] = limit;
		dp[1][2] = limit;
		for(int i=2; i<= N; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}
		
		result = Math.min(dp[N][1], dp[N][2]);
		
		// 1 = G(1)
		for(int i=2; i<= N; i++) {
			dp[1][0] = limit;
			dp[1][1] = cost[1][1];
			dp[1][2] = limit;
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}
		
		result = Math.min(Math.min(dp[N][0], dp[N][2]), result);
		
		// 1 = B(2)
		for(int i=2; i<= N; i++) {
			dp[1][0] = limit;
			dp[1][1] = limit;
			dp[1][2] = cost[1][2];
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}
		result = Math.min(Math.min(dp[N][0], dp[N][1]), result);

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}