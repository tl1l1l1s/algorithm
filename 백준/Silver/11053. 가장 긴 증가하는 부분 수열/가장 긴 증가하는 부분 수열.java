import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dp = new int[N];
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			
			for(int j=0; j<i; j++) {
				
				if(arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			result = Math.max(result, dp[i]);
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}