import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] weight = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					int sum = weight[i] + weight[j];
					
					if(sum == M) {
						max = M; break;
					}else if(sum < M) {
						max = Math.max(max, sum);
					}
				}
			}
	
			bw.write("#" + tc + " " + max + "\n");
			
		}		

		bw.flush();
		bw.close();
		br.close();

	}

}