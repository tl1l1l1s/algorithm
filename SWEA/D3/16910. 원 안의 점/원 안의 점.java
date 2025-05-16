import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// x^2 + y^2 <= N^2
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			
			for(int i=0; i<=N; i++) {
				for(int j=0; j<=N; j++) {
					
					if(i*i + j*j > N * N) {
						continue;
					}
					
					if(i==0 && j==0) {
						result += 1;
					} else if(i == 0 || j == 0) {
						result += 2;
					} else {
						result += 4;
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