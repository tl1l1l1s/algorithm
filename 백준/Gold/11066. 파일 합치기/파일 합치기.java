import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static int[] files;
	static int[][] dp;
	
	public static void solution() {
		for(int i=1; i<=K; i++) {
			dp[i][i] = 0;
		}
		
		for(int gap = 1; gap<K; gap++) { // 처리할 파일 그룹의 크기 - 1 (구간 길이)
			for(int start = 1; start+gap<=K; start++) { // 파일 그룹의 시작 인덱스
				int end = start+gap; // 파일 그룹의 끝 인덱스
				
				dp[start][end] = Integer.MAX_VALUE;
				for(int mid = start; mid<end; mid++) {  
					dp[start][end] = Math.min(dp[start][end], // 현재 
									dp[start][mid] + dp[mid+1][end] + (files[end] - files[start-1]));
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		for(int i=0; i<T; i++) {
			K = Integer.parseInt(br.readLine()); // 소설을 구성하는 장의 수
			files = new int[K+1];
			dp = new int[K+1][K+1];
			
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=K; j++) {
				int cost = Integer.parseInt(st.nextToken());
				files[j] = files[j-1] + cost;
				
			}
			solution();
			bw.write(dp[1][K] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}