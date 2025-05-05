import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N+1];
			
			dp[0] = 1;
			dp[1] = 1;
			
			if(N>=2) {
				dp[2] = 1;
			}
			
			for(int j=3; j<N; j++) {
				dp[j] = dp[j-2] + dp[j-3];
			}
			bw.write(dp[N-1] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}