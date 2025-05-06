import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String result = "";
			
			for(int i=0; i<money.length; i++) {
				if(N/money[i] >= 0) {
					result = result.concat(N/money[i] + " ");
					N%=money[i];
				}
			}
			
			bw.write("#" + tc + "\n" + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}