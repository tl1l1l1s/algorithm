import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[44];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<44; i++) {
			dp[i] = 1 + dp[i-1] + dp[i-2];
		}
		
		for(int t=0; t<T; t++) {
			long V = Long.parseLong(br.readLine());
		
			for(int i=1; i<44; i++) {
				if(dp[i] > V) {
					bw.write((i-1) + "\n");
					break;
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}

}