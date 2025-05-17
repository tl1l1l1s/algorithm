import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// N 길이의 정원
		// D 분무기 범위
			// D==1 2D+1
			// 1-> 0,1,2
				// 1이면 3, 5/3 = 1...2 -> 2
			// D==2 2D+1
			// 3-> 1,2,3,4,5
				//2이면 5, 5/5 = 1...
					// 나머지가 있으면 1회 추가
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int p = 2*D + 1;
			bw.write("#" + tc + " ");
			if(N%p != 0) {
				bw.write((N/p + 1) + "");
			} else {
				bw.write((N/p) + "");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}