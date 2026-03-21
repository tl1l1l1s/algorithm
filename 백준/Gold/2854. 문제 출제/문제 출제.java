import java.io.*;
import java.util.*;

public class Main {
	final static int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] fixed = new int[N+1]; // 고정 문제
		int[] variable = new int[N+1]; // 가변 문제
		
		long[][] dp = new long[N+1][2];
		Arrays.fill(variable, 0);
		
		dp[0][0] = 1;
		dp[0][1] = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			fixed[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N; i++) { //v[i] = i 혹은 i+1의 문제
			int x = Integer.parseInt(st.nextToken());
			variable[i] = x;
		}
		
		for(int i=1; i<=N; i++) {
			if(i > 1) { // i-1번 문제를 가변에서 선택하는 경우를 따로 계산
				dp[i-1][1] = (dp[i-2][0] + dp[i-2][1] % MOD) * variable[i-1] % MOD;
			}
			
			// i번 문제를 고정으로 선택하는 경우
			dp[i][0] = (dp[i-1][0] + dp[i-1][1]) * fixed[i] % MOD;
			if(i > 1) { // i번 문제를 가변으로 선택하는 경우
				dp[i][0] += dp[i-1][0] * variable[i-1]; // i-1에서 고정 * 현재 가변
				dp[i][0] += dp[i-1][1] * (variable[i-1]-1); // i-1에서 가변 * 현재 가변 - 이전에 가변으로 하나 사용했으므로 1
			}
			dp[i][0] %= MOD;
		}

		bw.write(dp[N][0] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}