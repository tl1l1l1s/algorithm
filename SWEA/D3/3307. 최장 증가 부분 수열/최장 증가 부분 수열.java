import java.io.*;
import java.util.*;

class Solution {
	
	static int[] nums;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			nums = new int[N];
			dp = new int[N];
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				dp[i] = 1;
			}

			int result = 1;
			for(int i=1; i<N; i++) {
				for(int j=0; j<i; j++) {
					if(dp[j] >= dp[i] && nums[i] > nums[j]) {
						dp[i] = dp[j] + 1;
					}
				}
				result = Math.max(result, dp[i]);
			}
			bw.write("#" + tc + " " + result + "\n");

		}

		bw.flush();
		bw.close();
		br.close();

	}

}