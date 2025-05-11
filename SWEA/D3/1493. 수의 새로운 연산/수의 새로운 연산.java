import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[301][301];
		Arrays.fill(matrix[0], 1);
		for(int i=1; i<301; i++) {
			matrix[i][1] = matrix[i-1][1] + i-1;
		}
		
		for(int i=2; i<301; i++) {
			for(int j=1; j<301; j++) {
				matrix[j][i] = matrix[j][i-1] + i + j - 1;
			}
		}
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int pX = 0, pY = 0, qX  = 0, qY = 0;
			for(int i=0; i<301; i++) {
				for(int j=0; j<301; j++) {
					if(matrix[i][j] == p) {
						pX = i; pY = j;
					}
					if(matrix[i][j] == q) {
						qX = i; qY = j;
					}
				}
			}
			
			bw.write("#" + tc + " " + matrix[pX + qX][pY + qY] + "\n");	
		}

		bw.flush();
		bw.close();
		br.close();

	}

}