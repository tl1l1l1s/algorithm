import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			coins[i] = Integer.parseInt(br.readLine()); 
		}

		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=k; j++) {
				if(j >= coins[i]) {
					dp[j] = dp[j] + dp[j - coins[i]];
				}
			}
		}
		
		bw.write(dp[k] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}