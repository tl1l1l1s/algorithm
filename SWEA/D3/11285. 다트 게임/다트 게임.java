import java.io.*;
import java.util.*;

class Solution {

	static final int[] radiusSquared = {
	        400, 1600, 3600, 6400, 10000, 
	        14400, 19600, 25600, 32400, 40000
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 원점, 20~200.. 10개 구간
		// 지점을 감싸는 가까운 원 반지름이 20*(11-p)인 경우 p점
		// 가장 큰 원 바깥 = 0점
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int result = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				double dist = (x*x + y*y);
				for(int j=0; j<10; j++) {
					if(dist <= radiusSquared[j]) {
						result += 10-j;
						break;
					}
				}
				
			}
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}