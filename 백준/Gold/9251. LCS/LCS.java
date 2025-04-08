import java.io.*;

public class Main {
	static char[] str1;
	static char[] str2;
	static Integer[][] dp;
	
	static int solution(int x, int y) {
		if(x < 0 || y < 0) {
			return 0;
		}
		
		if(dp[x][y] == null) {
			dp[x][y] = 0;
			
			if(str1[x] == str2[y]) {
				dp[x][y] = solution(x-1, y-1) + 1;
			} else {
				dp[x][y] = Math.max(solution(x-1, y), solution(x, y-1));
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		dp = new Integer[str1.length][str2.length];

		bw.write(solution(str1.length - 1, str2.length - 1) + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}