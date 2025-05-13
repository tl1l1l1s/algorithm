import java.io.*;
import java.util.*;

class Solution {
	
	static int N;
	static int K;
	static int[] nums;
	static int result;
	
	static void solution(int idx, int sum) { // dfs 사용
		// 만약 전체 합이 K와 동일한 경우 result++; return;
		if(sum != 0 && sum == K) {
			result++;
			return;
		}
		
		// 전체 합이 K보다 큰 경우 return;
		if(idx == N || sum > K) return;
		
		// 작은 경우 계속 진행
		solution(idx+1, sum + nums[idx]); // 본인을 포함하는 경우
		solution(idx+1, sum); // 본인 제외
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			solution(0, 0);
			bw.write("#" + tc + " " + result + "\n");
		}
        
		bw.flush();
		bw.close();
		br.close();

	}

}