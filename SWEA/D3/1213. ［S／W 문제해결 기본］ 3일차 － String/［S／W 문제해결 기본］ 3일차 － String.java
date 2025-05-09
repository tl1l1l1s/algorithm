import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int tc = 1; tc <= 10; tc++) {
			int result = 0;
			
			br.readLine();
			
			String keyword = br.readLine();
			String str = br.readLine();
			
			int curr = str.indexOf(keyword);
			
			while(curr != -1) {
				result++;
				str = str.substring(curr+keyword.length(), str.length());
				curr = str.indexOf(keyword);
			}
		
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}