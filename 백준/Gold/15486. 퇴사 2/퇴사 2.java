import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] consulting = new int[N+1][2];
		int result = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());

			consulting[i][0] = Integer.parseInt(st.nextToken()); // 0 = T (시간)
			consulting[i][1] = Integer.parseInt(st.nextToken()); // 1 = P (수익)
		}
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, 0);
		for(int i=0; i<N; i++) {
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
			
			int t = consulting[i][0];
			int p = consulting[i][1];
			if(i + t <= N) {
				dp[i + t] = Math.max(dp[i + t], dp[i] + p);
			}
		}

        for (int i = 0; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }
        bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();

	}

}