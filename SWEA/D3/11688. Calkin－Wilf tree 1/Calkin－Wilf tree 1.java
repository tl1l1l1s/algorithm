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
			String command = br.readLine();
			int a = 1, b = 1;
			
			for(char x : command.toCharArray()) {
				if(x == 'L') {
					b = a+b;
				} else if(x == 'R') {
					a = a+b;
				}
			}
			bw.write("#" + test_case + " " + a + " " + b + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}