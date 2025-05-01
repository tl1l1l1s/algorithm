import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] wine = new int[N+1];

		for(int i=1; i<=N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] =  wine[1];
		if(N >= 2) {
			dp[2] = wine[1] + wine[2];
		}
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-1], // 현재 포도주 선택 X
					Math.max(dp[i-2] + wine[i], // 2번 이전 + 현재 포도주 선택
							dp[i-3] + wine[i-1] + wine[i])); // 3번 이전 + 이전 포도주, 현재 포도주 선택
		}
		
		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}