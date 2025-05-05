import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 연속된 수 중 몇 개 이상, 합 중 가장 큰 합을 구하고 
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		int[] dp = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = nums[0];
		int result = dp[0];
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
			result = Math.max(result, dp[i]);
		}
		
		 bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}