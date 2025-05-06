import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			String str = Integer.toString(i);
			
			if(str.contains("3") || str.contains("6") || str.contains("9")) {
				for(int j=0; j<str.length(); j++) {
					str = str.replaceAll("[369]", "-");
				}
				str = str.replaceAll("[0124578]", "");
			}
			bw.write(str + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}