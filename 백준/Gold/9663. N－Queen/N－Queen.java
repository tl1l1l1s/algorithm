import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static int[][] drc = {
			{-1, 0},
			{-1, -1}, {-1, 1}
	};
	
	static int dfs(boolean[][] board, int row) {
		int result = 0;
		
		if(row == N) { // check는 이미 상단에서 통과, row == N이면 끝, return 1;
			return 1;
		}
		
		for(int col=0; col<N; col++) {
			if(check(board, row, col)) {
				board[row][col] = true;
				result += dfs(board, row+1);
				board[row][col] = false;
			}
		}
		
		return result;
	}
	
	static boolean check(boolean[][] board, int row, int col) {
		for(int i=0; i<3; i++) { // drc를 순회하면서 더하고 빼고 할 거임
			int nR = row + drc[i][0];
			int nC = col + drc[i][1];
			
			// r, c에 drc 3개를 각각 더 하며 0이나 N을 넘지 않을 때까지 확인
			while(nR >= 0 && nR < N
					&& nC >= 0 && nC < N) {
				
				if(board[nR][nC]) {
					return false;
				}
				
				nR += drc[i][0];
				nC += drc[i][1];
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N*N 보드에 N개의 퀸을 공격하지 못 하게 놓는 경우
		N = Integer.parseInt(br.readLine());
			
		boolean[][] board = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = false;
			}
		}
			
		bw.write(dfs(board, 0) + "\n");	
	
		bw.flush();
		bw.close();
		br.close();

	}
}