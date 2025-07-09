import java.io.*;
import java.util.*;

public class Main {
	static int[][] drc = {
			{1, 0}, {-1, 0},
			{0, 1}, {0, -1}
	};
	static class Loc {
		private int x;
		private int y;
		
		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 목표 지점까지의 모든 지점에 대한 거리 
			// n = 세로, m = 가로
			// 0 = 갈 수 X 땅
			// 1 = 갈 수 있는 땅
			// 2 = 목표 지점
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] board = new int[n][m];
		
		int pX = 0; int pY = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(board[i], -1);
			
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) {
					pX = i; pY = j;
				} else if(map[i][j] == 0) {
					board[i][j] = 0;
				}
			}
		}
		
		LinkedList<Loc> q = new LinkedList<Loc>();
		q.add(new Loc(pX, pY));
		board[pX][pY] = 0;
		
		while(!q.isEmpty()) {
			Loc current = q.poll();
			
			for(int i=0; i<4; i++) {
				int nextX = current.x + drc[i][0];
				int nextY = current.y + drc[i][1];
				if(nextX >= 0 && nextX < n
						&& nextY >= 0 && nextY < m
						&& board[nextX][nextY] == -1) {
					board[nextX][nextY] = board[current.x][current.y] + 1;
					q.offer(new Loc(nextX, nextY));
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				bw.write(board[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}