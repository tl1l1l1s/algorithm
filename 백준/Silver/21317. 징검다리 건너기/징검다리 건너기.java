import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 100001;
	static int N;
	static int K;
	static int[][] e;
	static int[][] memoization;
	
	static void solution(int n, int used) {
		if(n > N) {
			return;
		}
		
		// 1. 점프 1 사용하는 경우
		if(n+1 <= N) {
			memoization[n+1][used] = Math.min(memoization[n+1][used], memoization[n][used] + e[n][0]);
			solution(n+1, used);
		}
			
		// 2. 점프 2 사용하는 경우
		if(n+2 <= N) {
			memoization[n+2][used] = Math.min(memoization[n+2][used], memoization[n][used] + e[n][1]);
			solution(n+2, used);
		}
		
		// 3. 점프 3 사용하는 경우
		if(n+3 <= N && used == 0) { // 0 == 미사용
			memoization[n+3][1] = Math.min(memoization[n+3][1], memoization[n][used] + K);
			solution(n+3, 1);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 점프 1 : +1 (e[0])
		// 점프 2 : +2 (e[1])
		// 점프 3 : +3 (k 소비)
		N = Integer.parseInt(br.readLine());
		
		e = new int[N+1][2];
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			e[i][0] = Integer.parseInt(st.nextToken());
			e[i][1] = Integer.parseInt(st.nextToken());
		}
		
		memoization = new int[N+1][2]; // 0 = 큰 점프 사용, 1 = 큰 점프 미사용
		Arrays.fill(memoization[1], 0);
		for(int i=2; i<=N; i++) {
			Arrays.fill(memoization[i], INF);
		}
		
		K = Integer.parseInt(br.readLine());
		solution(1, 0);
	
		// 필요한 최소 에너지 출력
		bw.write(Math.min(memoization[N][0], memoization[N][1]) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}