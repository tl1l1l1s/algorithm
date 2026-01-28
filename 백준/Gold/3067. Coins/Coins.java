import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        // 주어진 코인을 사용해 금액을 만들기
        
		int T = Integer.parseInt(br.readLine());
        
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 코인 수
			st = new StringTokenizer(br.readLine());
            
			int[] ms = new int[N];
			for(int i=0; i<N; i++) {
				ms[i] = Integer.parseInt(st.nextToken()); // 코인
			}
            
			int M = Integer.parseInt(br.readLine()); // 목표 금액
			
			long[] dp = new long[M+1];
			dp[0] = 1; // 0원을 만들 수 있는 방법 1가지
			
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