import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] maxDp = new int[N][3];
		int[][] minDp = new int[N][3];
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<3; j++) {
				int x = Integer.parseInt(st.nextToken());
				maxDp[i][j] = x;
				minDp[i][j] = x;
			}
		}
		

		int maxResult = Integer.MIN_VALUE;
		int minResult = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				
				if(i-1 >= 0) {
					if(j-1 >= 0) {
						max = Math.max(max, maxDp[i-1][j-1] + maxDp[i][j]);
					}
					if(j+1 < 3) {
						max = Math.max(max, maxDp[i-1][j+1] + maxDp[i][j]);
					}
					
					maxDp[i][j] = Math.max(max, maxDp[i-1][j] + maxDp[i][j]);
				}
				
				if(i-1 >= 0) {
					if(j-1 >= 0) {
						min = Math.min(min, minDp[i-1][j-1] + minDp[i][j]);
					}
					if(j+1 < 3) {
						min = Math.min(min, minDp[i-1][j+1] + minDp[i][j]);
					}
					minDp[i][j] = Math.min(min, minDp[i-1][j] + minDp[i][j]);
					
					
				}
				if(i==N-1) {
					maxResult = Math.max(maxResult, maxDp[i][j]);
					minResult = Math.min(minResult, minDp[i][j]);
				}
			}
		}
		
		bw.write(maxResult + " " + minResult);
		
		bw.flush();
		bw.close();
		br.close();

	}

}