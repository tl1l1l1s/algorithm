import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			int total = 0;
			
			int[] nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				total += nums[i];
			}
			
			boolean[] dp = new boolean[total+1];
			
			dp[0] = true;
			for(int i=0; i<N; i++) {
				for(int j=total; j>=nums[i]; j--) { // 역순으로 순회하여
					if(dp[j-nums[i]]) { // dp[j-nums[i]]가 true로 이미 존재하면
						dp[j] = true;
					}
				}
			}
			
			
			for(int i=0; i<=total; i++) {
				if(dp[i]) result++;
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
// 제한 시간 초과
// 조합의 시간 복잡도 = 2^N, 같은 합계여도 여러 번 반복 계산
// 위 DP = N*sum = true만 추적하므로 효율적
//	static int[] nums;
//	static boolean[] dp;
//	
//	static void solution(int c, int smallest, int sum) {
//		// 조합으로 뽑을 수 있는만큼 뽑고 dp에 추가
//		dp[sum] = true;
//		
//		if(c == 0) { // 최대한 뽑을 수 있는 만큼 뽑은 경우
//			return;
//		}
//		
//		for(int i=smallest; i<nums.length; i++) {
//			solution(c-1, i+1, sum + nums[i]);
//		}
//		return;
//	}
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
//		
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int tc=1; tc<=T; tc++) {
//			int N = Integer.parseInt(br.readLine());
//			int result = 0;
//			int total = 0;
//			
//			nums = new int[N];
//			st = new StringTokenizer(br.readLine());
//			for(int i=0; i<N; i++) {
//				nums[i] = Integer.parseInt(st.nextToken());
//				total += nums[i];
//			}
//			
//			dp = new boolean[total+1];
//			solution(nums.length, 0, 0);
//			for(int i=0; i<=total; i++) {
//				if(dp[i]) result++;
//			}
//			bw.write("#" + tc + " " + result + "\n");
//		}
//		bw.flush();
//		bw.close();
//		br.close();
//	}
}