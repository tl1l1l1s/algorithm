import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 활성화 되어있는 앱 개수
		int M = Integer.parseInt(st.nextToken()); // 추가로 필요한 메모리
		st = new StringTokenizer(br.readLine());
		int[] n = new int[N+1];
		for(int i=1; i<=N; i++) {
			n[i] = Integer.parseInt(st.nextToken()); // 앱이 사용 중인 메모리
		}
		st = new StringTokenizer(br.readLine());
		int[] m = new int[N+1];
		for(int i=1; i<=N; i++) {
			m[i] = Integer.parseInt(st.nextToken()); // 앱 비활성화 비용
		}
		
		int[][] dp = new int[N+1][100001]; // K번째 앱, j 비용을 사용했을 때의 최대 메모리 크기
		
		int result = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=100000; j++) {
				if(N != 1 && i==1) {
					if(j - m[i] >= 0) {
						dp[i][j] = n[i];
					}
				} else {
					if(j - m[i] >= 0) {
						dp[i][j] = Math.max(dp[i-1][j-m[i]] + n[i], dp[i-1][j]);
					} else {
						dp[i][j] = dp[i-1][j];
					}
					
					if(dp[i][j] >= M) result = Math.min(result, j);
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}