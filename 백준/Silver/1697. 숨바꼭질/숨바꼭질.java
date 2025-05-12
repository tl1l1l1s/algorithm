import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dp = new int[200001];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i=0; i<200001; i++) {
			dp[i] = 200001;
		}
		

		int limit = N;
		if(N==0) {
			limit = K*2;
		} else {
			while(limit<K) {
				limit *= 2;
			}
		}
		
		// 걷는 경우 X+1, X-1
		// 순간이동하는 경우 2*X
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		dp[N] = 0;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			if(current == K) {
				// BFS이므로 제일 먼저 도착 = 최단 거리, break;
				break;
			}
			
			if(current-1 >= 0 // 0 미만으로 가지 않도록 제한
					&& dp[current -1] > dp[current] + 1) { // -1
				q.add(current - 1);
				dp[current-1] = dp[current] + 1;
				
			}
			
			if(current != 0 && current*2 <= limit && dp[current * 2] > dp[current] + 1) { // *2
				// 말도 안 되는 수까지 *2 하게 되는 경우를 방지하기 위해 limit 이하로 제한
				q.add(current * 2);
				dp[current * 2] = dp[current] + 1;
			}
				
			if(dp[current + 1] > dp[current] + 1) { // +1
				q.add(current + 1);
				dp[current + 1] = dp[current] + 1;
			}
		}
		
		bw.write(dp[K] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}