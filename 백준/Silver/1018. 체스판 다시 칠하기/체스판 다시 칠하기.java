import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 경우의 수 (체스판)
			// 1. 맨 왼 위 흰색
			// 2. 맨 왼 위 검은색
		
		// 맞닿은 면 중 두 개 이상이 다른 색으로 칠해져있지 않은 사각형의 경우
		// 위, 아래, 왼, 오
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] board = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<M; j++) {
				if(str.charAt(j) == 'B') {
					board[i][j] = false;
				} else board[i][j] = true;
			}
		}
		
		int row = N - 7;
		int col = M - 7;
		
		boolean TF;
		int min = Integer.MAX_VALUE;
		int count = 0;
		for(int x=0; x<row; x++) {
			for(int y=0; y<col; y++) {
				count = 0;
				TF = board[x][y];
				
				for(int i=x; i<x+8; i++) {
					for(int j=y; j<y+8; j++) {
						if(board[i][j] != TF) {
							count++;
						}
						TF = (!TF);
					}
					TF = (!TF);
				}
			count = Math.min(count, 64 - count);
			min = Math.min(count, min);
			}
		}
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}