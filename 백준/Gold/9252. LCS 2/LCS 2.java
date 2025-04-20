import java.io.*;
import java.util.*;

public class Main {
	static char[] str1;
	static char[] str2;
	static String[][] dp;
	
	static String solution(int x, int y) {
		if(x < 0 || y < 0) {
			return "";
		}
		
		if(dp[x][y] == null) {
			if(str1[x] == str2[y]) {
				dp[x][y] = solution(x-1, y-1) + str1[x];
			} else {
				String sol1 = solution(x-1, y);
				String sol2 = solution(x, y-1);
				dp[x][y] = sol1.length() > sol2.length() ? sol1 : sol2;
			}
		}
		
		return dp[x][y];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// LCS, 부분 수열 중 가장 긴 것을 찾는 방법
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		dp = new String[str1.length][str2.length];
	
		String result = solution(str1.length - 1, str2.length - 1);
		bw.write(result.length() + "\n" + result);
		bw.flush();
		bw.close();
		br.close();

	}

}