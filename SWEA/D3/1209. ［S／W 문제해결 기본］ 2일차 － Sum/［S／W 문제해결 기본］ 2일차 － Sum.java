import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			
			int temp;
			int row = 0;
			int col = 0;
			int rDiagonal = 0;
			int lDiagonal = 0;
			
			int[][] board = new int[100][100];
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
                temp = 0;
				for(int j=0; j<100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					temp += board[i][j]; 
				}
				row = Math.max(row, temp);
			}
			
			for(int i=0; i<100; i++) {
                temp = 0;
				for(int j=0; j<100; j++) {
					temp += board[j][i];
				}
				col = Math.max(col, temp);
				rDiagonal += board[i][i];
				lDiagonal += board[i][99-i];
			}
			
			bw.write("#" + tc + " " + Math.max(row, Math.max(col, Math.max(rDiagonal, lDiagonal))) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}