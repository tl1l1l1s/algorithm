import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Long[] dp = new Long[N+1];
		
		dp[0] = 0L;
		dp[1] = 0L;
        if(N > 1) {
		    dp[2] = 1L;
        }

		for(int i = 3; i<=N; i++) {
			dp[i] = (i-1)*(dp[i-2] + dp[i-1])%1000000000;
		}
		
		System.out.println(dp[N]);

	}

}
