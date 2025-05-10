import java.io.*;
import java.util.*;

class Solution {
	
	static int N;
	static int[][] board;
	
	static final int[][] drc = {
			{-1, 0}, {1, 0}, // |
			{0, 1}, {0, -1}, // -
			{1, 1}, {-1, -1}, // \
			{-1, 1}, {1, -1} // /
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			board = new int[N+1][N+1]; // 1: 흑, 2: 백
			
			for(int i=0; i<=N; i++) { // 0: 초기화
				Arrays.fill(board[i], 0);
			}
			
			// 초기 보드 세팅
			// 3, 3 = 2 
			// 3, 4 = 1
			// 4, 3 = 1
			// 4, 4 = 2
			board[N/2][N/2] = 2;
			board[N/2][N/2+1] = 1;
			board[N/2+1][N/2] = 1;
			board[N/2+1][N/2+1] = 2;
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				board[x][y] = c;
				
				int nX; int nY;
				for(int d=0; d<8; d++) {
					nX = x + drc[d][0];
					nY = y + drc[d][1];
					
					inner:
					while(nX>=0 && nX<=N
							&& nY>=0 && nY<=N) {
						if(board[nX][nY] == 0) break inner;
						else if(board[nX][nY] == c) {
							// 그 사이의 값을 변경
							int tX = nX - drc[d][0];
							int tY = nY - drc[d][1];
							
							while(tX != x || tY != y) {
								board[tX][tY] = c;
								tX = tX - drc[d][0];
								tY = tY - drc[d][1];
							}
							break;
						} 
						
						nX = nX + drc[d][0];
						nY = nY + drc[d][1];
					}
				}
			}
			
			int b = 0; int w = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(board[i][j] == 1) b++;
					else if(board[i][j] == 2) w++;
				}
			}
			bw.write("#" + tc + " " + b + " " + w + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}