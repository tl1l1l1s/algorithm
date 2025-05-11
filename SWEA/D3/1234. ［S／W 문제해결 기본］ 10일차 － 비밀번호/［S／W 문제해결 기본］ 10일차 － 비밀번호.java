import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String code = st.nextToken();
			
			int start = 0;
			int end = start+1;
			while(start >= 0 && end < code.length()) {
				if(code.charAt(start) == code.charAt(end)) {
					code = code.substring(0, start) + code.substring(end+1, code.length());
					start--; end--;
					
					if(code.length() > 0 && start < 0) {
						start++;
						end++;
					}
				} else {
					start++;
					end++;
				}
			}
		
			bw.write("#" + tc + " " + code + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}