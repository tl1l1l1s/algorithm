import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] scores = new int[N+1];
		int[] dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			scores[i] = Integer.parseInt(st.nextToken());
			
			for(int j=i; j>=1; j--) {
				max = Math.max(max, scores[j]);
				min = Math.min(min, scores[j]);
				dp[i] = Math.max(dp[i], max - min + dp[j-1]);
			}
		}
		
		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		
	}
}
