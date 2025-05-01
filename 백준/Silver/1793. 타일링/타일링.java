import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 2x1, 2x2 타일로 채우는 방법의 수를 구한다
		// 점화식 = dp[n-1] + 2*dp[n-2]
		
		BigInteger[] dp = new BigInteger[251];
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.valueOf(3);
		
		for(int i=3; i<251; i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.TWO));
		}
		
		String input = null;
		while((input = br.readLine()) != null) {	
			int n = Integer.parseInt(input);
			bw.write(dp[n] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}