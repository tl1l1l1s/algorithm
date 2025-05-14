import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] weight;
	static int[] cost;
	static Integer[][] dp; // [현재 넣은 아이템 번호][부피]에서 가질 수 있는 최대 가치를 저장
	
	static int solution(int i, int k) {
		if(i < 0) return 0;
		
		if(dp[i][k] == null) {
			
			if(weight[i] > k) { // 현재 물건의 무게가 k보다 큰 경우
				dp[i][k] = solution(i-1, k); // 재귀를 통해 i-1, k의 값 그대로
				
			} else {
				// k보다 작은 경우 == 넣을 수 있음
				dp[i][k] = Math.max(solution(i-1, k), // i-1, k의 값
						solution(i-1, k-weight[i]) + cost[i]); // (i-1, k-현재 부피) + 현재 가치
			}
		}
		
		return dp[i][k];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			dp = new Integer[N][K+1];
			weight = new int[N];
			cost = new int[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}
			bw.write("#" + tc + " " + solution(N-1, K) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}