import java.io.*;
import java.util.*;

public class Main {
	static Integer[][] dp;
	static int[] weight;
	static int[] value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		dp = new Integer[N][K+1];
		weight = new int[N];
		value = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(knapsack(N-1, K));
	}
	
	// dp 실행
	static int knapsack(int i, int k) {
		if(i<0) return 0;
		
		if(dp[i][k] == null) {
			// 현재 물건(i)의 무게가 k보다 더 나가는 경우
			if(weight[i] > k) {
				// 전 i의 값을 가져옴 ( 0)
				dp[i][k] = knapsack(i-1, k);
			}
			// 현재 물건(i)의 무게가 k보다 덜 나가거나 같은 경우 
			else {
				// 현재 물건 + 물건에서 뺀 만큼의 dp 값 / 전 i의 값 중 어디가 큰지 비교
				dp[i][k] = Math.max(knapsack(i-1, k), (knapsack(i-1, k-weight[i])+value[i]));
			}
		}
		
		
		return dp[i][k];
	}
}