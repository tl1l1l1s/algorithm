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
			int result = 0;
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String scStr = br.readLine();
			
			for(int i=0; i<length; i++) {
				if(str.charAt(i) == scStr.charAt(i)) {
					result++;
				}
			}
			bw.write("#" + test_case + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}