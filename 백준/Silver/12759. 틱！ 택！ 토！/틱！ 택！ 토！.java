import java.io.*;
import java.util.*;

public class Main {
	
	static int res;
	static int[][] board;
	
	static int findWinner() {
		// 가로
		boolean res = true;
		for(int i=1; i<4; i++) {
			res = true;
			int x = board[i][1];
			
			for(int j=1; j<4; j++) {
				if(x != board[i][j]) {
					res = false;
					break;
				}
			}
			
			if(res) {
				return x;
			}
		}
		
		// 세로
		for(int i=1; i<4; i++) {
			res = true;
			int x = board[1][i];
			
			for(int j=1; j<4; j++) {
				if(x != board[j][i]) {
					res = false;
					break;
				}
			}
			
			if(res) {
				return x;
			}
		}
		
		// 대각선
		if(board[1][1] == board[2][2] && board[2][2] == board[3][3]) return board[1][1];
		if(board[1][3] == board[2][2] && board[2][2] == board[1][3]) return board[1][3];
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 가로줄 2줄, 세로줄 2줄
		// 플레이어 1은 O, 플레이어 2는 X

		int start = Integer.parseInt(br.readLine());
		board = new int[4][4];
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x][y] = start;
			
			if((res = findWinner()) != 0) {
				bw.write(res + "\n");
				break;
			}
			start = (start == 1 ? 2 : 1);
		}
		
		if(res == 0) bw.write("0\n");
		bw.flush();
		bw.close();
		br.close();

	}

}