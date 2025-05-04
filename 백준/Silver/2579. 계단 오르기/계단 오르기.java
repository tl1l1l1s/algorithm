import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stair[1];
		
		if(N>=2) {
			dp[2] = dp[1] + stair[2];
		}
		
		for(int i=3; i<=N; i++) {
			// _ _ _ curr
			dp[i] = Math.max(dp[i-2], // o x x _
					dp[i-3] + stair[i-1] // o o x _
							) + stair[i]; // current를 확실히 o
		}

		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
	
	// top-down
//	static int dp(int N) {
//		if(dp[N] == null) {
//			dp[N] = Math.max(dp(N-2), dp(N-3) + stair[N-1]) + stair[N];
//		}
//		
//		return dp[N];
//	}

}