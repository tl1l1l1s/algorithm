import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 마법 1 : +1
		// 마법 2 : *2
		// 마법 3 : *10, 단 한 번만 사용 가능

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken()); // to be
		int[][] dp = new int[b+1][2]; // [연산 값][Chance 사용 여부]
		
		for(int i = a+1; i<=b; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[a][0] = 0; // 시작점
		dp[a][1] = Integer.MAX_VALUE; // 접근 불가능
		
        // bottom-up 사용하여 한 번씩만 처리
		for(int i=a; i<b; i++) {
			dp[i+1][0] = Math.min(dp[i][0] + 1, dp[i+1][0]);
			
			if(2*i <= b) {
				dp[2*i][0] = Math.min(dp[i][0] + 1, dp[2*i][0]);
			}
			
			if(10*i <= b) {
				dp[10*i][1] = Math.min(dp[i][0] + 1, dp[10*i][1]);
			}
			
			if(dp[i][1] != Integer.MAX_VALUE) {
				if(i + 1 <= b) {
					dp[i+1][1] = Math.min(dp[i][1] + 1, dp[i+1][1]);					
				}

				if(2*i <= b) {
					dp[2*i][1] = Math.min(dp[i][1] + 1, dp[2*i][1]);
				}
			}
		}
		
		bw.write(Math.min(dp[b][0], dp[b][1]) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}