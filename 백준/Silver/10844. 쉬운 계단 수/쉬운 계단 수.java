import java.io.*;

public class Main {
	
	static Long[][] dp;
	
	static long solution(int digit, int val) {
		if(digit == 1) {
			return dp[digit][val];
		}
		
		if(dp[digit][val] == null) {
			if(val == 0) { 	// 0이면 1 밖에 못 들어가므로
				dp[digit][val] = solution(digit - 1, 1);
			} else if(val == 9) { // 9면 8 밖에 못 들어가므로
				dp[digit][val] = solution(digit - 1, 8);
			} else {
				dp[digit][val] = solution(digit - 1, val - 1) + solution(digit - 1, val + 1);
			}
		}
		
		return (dp[digit][val]) % 1000000000;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long result = 0;
		
		// N = 자릿수. 10 = 각각의 자릿값 
		dp = new Long[N+1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}
		
		for(int i = 1; i < 10; i++) {
			result += solution(N, i);
		}
		
		bw.write((result % 1000000000) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}
