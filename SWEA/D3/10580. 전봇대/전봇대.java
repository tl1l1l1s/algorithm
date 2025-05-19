import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] set = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				set[i][0] = Integer.parseInt(st.nextToken());
				set[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if ((set[i][0] < set[j][0] && set[i][1] > set[j][1]) || 
	                        (set[i][0] > set[j][0] && set[i][1] < set[j][1])) {
	                        result++;
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