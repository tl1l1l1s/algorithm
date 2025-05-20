import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// L 분 이상 U분 이하
		// 이번 주 X분
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int result = 0;
			// 제한 시간 이하 = 0, 넘었으면 -1
			// 필요 조건 못 맞췄으면 얼마나 더 필요한지
			
			if(L-X > 0) {
				result = L-X;
			}
		
			bw.write("#" + tc + " " + (result != 0 ? result : (
					U-X > 0 ? 0 : -1)) + "\n");

		}

		bw.flush();
		bw.close();
		br.close();

	}

}