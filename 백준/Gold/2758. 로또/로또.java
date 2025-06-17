import java.io.*;
import java.util.*;

public class Main {
	static long[][] dp = new long[11][2001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 1~m까지의 숫자 중 n개의 수를 고르는 로또
		// 이전에 고른 수보다 적어도 2배 이상 => 가능한 개수만큼 최대
		int T = Integer.parseInt(br.readLine());
		
		Arrays.fill(dp[0], 1);
		for(int j=1; j<=10; j++) {
			for(int k=1; k<=2000; k++) {
				dp[j][k] = // k까지의 숫자 중 j개 고르는 경우
						dp[j][k-1] // k를 선택하지 않는 경우 
						+ dp[j-1][k/2]; // k를 선택하는 경우
			}
		}
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			bw.write(dp[n][m] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}