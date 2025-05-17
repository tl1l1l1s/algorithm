import java.io.*;
import java.util.*;

class Solution {
	
	static final int[][] drc = {
			{0, 1}, {1, 0},
			{-1, 0}, {0, -1},
	};
	static int N;
	static int[][] board;
	static int[][] memoization;
	
	static int dfs(int x, int y) {
		int result = 1;
		for(int i=0; i<4; i++) {
			int nX = x + drc[i][0];
			int nY = y + drc[i][1];
			
			if(nX >= 0 && nX < N && nY >= 0 && nY < N && 
					board[nX][nY] == board[x][y] + 1) {
				if(memoization[nX][nY] == 0) {
					result += dfs(nX, nY);
				} else {
					result += memoization[nX][nY];
				}
			}
			memoization[x][y] = result;
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// N^2개의 방이 N*N 형태
		// 상하좌우 이동
		// 다음 칸의 방이 무조건 현 칸의 방보다 숫자 + 1
		// 최대로 이동할 수 있는 개수의 방
			// 동일하다면 제일 작은 수로

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());

			board = new int[N][N];
			memoization = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					memoization[i][j] = 0; // 초기값
				}
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(memoization[i][j] == 0) {
						memoization[i][j] = dfs(i, j);
					}
				}
			}

			int rR = Integer.MAX_VALUE; // 동일한 경우 방 번호 더 작은 걸로
			int rM =  -1; // 이동할 수 있는 최대 거리
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// memoization을 돌며 최대값을 찾는다
					if(rM < memoization[i][j]) {
						rM = memoization[i][j];
						rR = board[i][j];
					} else if(rM == memoization[i][j]) {
						rR = Math.min(rR, board[i][j]);
					}
				}
			}
			
			bw.write("#" + tc + " " + rR + " " + rM + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}