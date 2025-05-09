import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int result = 0;
			
			String memory = br.readLine();
			// i+1 값이 전 값과 동일한지 파악
			// 다른 경우 +1
			if(memory.charAt(0) == '1') result++;
			for(int i=1; i<memory.length(); i++) {
				if(memory.charAt(i-1) != memory.charAt(i)) {
					result++;
				}
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}