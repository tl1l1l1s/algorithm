import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][N];
		int[][] dp = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], 0);
			
			for(int j=0; j<i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = triangle[0][0];
		for(int i=1; i<N; i++) {
			for(int j=0; j<i+1; j++) {
				
				if(j-1 < 0) {
					dp[i][j] = dp[i-1][j] + triangle[i][j];
				} else if(j == i) {
					dp[i][j] = dp[i-1][j-1] + triangle[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
				}
			}
		}
		
		int result = 0;
		for(int num : dp[N-1]) {
			result = Math.max(num, result);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}