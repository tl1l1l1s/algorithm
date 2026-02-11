import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		

        long[][] dp = new long[30][30];

        // dp[0][j] = 1
        for (int j = 0; j < 30; j++) dp[0][j] = 1;

        // dp[i][j] = dp[i][j-1] + dp[i-1][j-1]
        for (int j = 1; j < 30; j++) {
            for (int i = 1; i <= j; i++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			bw.write(dp[N][M] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}