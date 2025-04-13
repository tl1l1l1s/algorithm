import java.io.*;
import java.util.*;

public class Main {
	static int price[][];
	static int dp[][];
	
	static int dp(int n, int c) {
		if(dp[n][c] == 0) {
			if(c == 0) {
				dp[n][c] = Math.min(dp(n-1, 1), dp(n-1, 2)) + price[n][0];
			} else if(c == 1) {
				dp[n][c] = Math.min(dp(n-1, 0), dp(n-1, 2)) + price[n][1];
			} else if(c == 2) {
				dp[n][c] = Math.min(dp(n-1, 0), dp(n-1, 1)) + price[n][2];
			}
		}
		
		return dp[n][c];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		price = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			price[i][0] = Integer.parseInt(st.nextToken());
			price[i][1] = Integer.parseInt(st.nextToken());
			price[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][3];
		for(int i=0; i<3; i++) {
			dp[0][i] = price[0][i];
		}
		
		bw.write(Math.min(dp(N-1, 0), Math.min(dp(N-1, 1), dp(N-1, 2))) + "\n");

		bw.flush();
		bw.close();
		br.close();

	}
}