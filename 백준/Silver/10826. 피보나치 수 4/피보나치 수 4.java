import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		BigInteger[] dp = new BigInteger[N+3];
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("1");
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		bw.write(dp[N].toString() + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}