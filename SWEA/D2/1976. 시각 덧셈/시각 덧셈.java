import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.valueOf(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int aH = Integer.parseInt(st.nextToken());
			int aM = Integer.parseInt(st.nextToken());
			int bH = Integer.parseInt(st.nextToken());
			int bM = Integer.parseInt(st.nextToken());
			
			int rH = 0, rM = 0;
			rM = aM + bM;
			if(rM >= 60) {
				rH += rM/60;
				rM %= 60;
			}
			
			rH += aH + bH;
			if(rH > 12) {
				rH -= 12;
                	// %로 했더니 12 0 12 0일 때 0 0 나와서 X
			}
			
			bw.write("#" + tc + " " + rH + " " + rM + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}