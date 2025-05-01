import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int x = 0;
			int check = 0; // 비트마스킹 사용
				
			while(check != (1 << 10) - 1) {
				int temp = (++x)*N;
				
				while(temp > 0) {
					check |= (1 << (temp%10));
					temp/=10;
				}
			}
			
			bw.write("#" + test_case + " " + (x*N) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}