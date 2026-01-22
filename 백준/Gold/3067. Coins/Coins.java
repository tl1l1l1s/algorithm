import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 1, 5, 10, 50, 100, 500
		// 주어진 금액의 모든 방법

		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 동전의 가지 수
			st = new StringTokenizer(br.readLine()); // 동전의 각 금액
			int[] ms = new int[N];
			for(int i=0; i<N; i++) {
				ms[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine()); // 만들어야 할 금액
			
			long[] dp = new long[M+1];
			dp[0] = 1;
			
			for(int coin: ms) {
				for(int x=coin; x<=M; x++) {
					dp[x] += dp[x - coin];
				}
			}
			
			bw.write(dp[M] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}