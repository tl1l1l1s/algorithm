import java.io.*;
import java.util.*;

public class Main {
	static int[][] horseDrc = {
			{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
			{1, -2}, {2, -1}, {2, 1}, {1, 2}
	};
	static int[][] monkeyDrc = {
			{0, 1}, {1, 0}, {-1, 0}, {0,- 1}
	};

	static class Position {
		int x;
		int y;
		int cK;
		int a;
		
		Position(int x, int y, int cK, int a) {
			this.x = x;
			this.y = y;
			this.cK = cK;
			this.a = a;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 말이 되고 싶은 원숭이
		// k번 말 행동 (나이트)
		// 이후 상하좌우만 이동 가능
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int result = Integer.MAX_VALUE;
		int[][] map = new int[H][W];
		boolean[][][][] isVisited = new boolean[H][W][K+1][2];
		for(int i=0; i<H; i++) {	
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				for(int k=0; k<=K; k++) {
					if(i==0 && j==0) {
						Arrays.fill(isVisited[i][j][k], true);
					} else {
						Arrays.fill(isVisited[i][j][k], false);						
					}
				}
			}
		}
	
		ArrayDeque<Position> dq = new ArrayDeque<Position>();
		dq.add(new Position(0, 0, K, 0));
		
		while(!dq.isEmpty()) {						
			Position currPosition = dq.poll();
			int x = currPosition.x;
			int y = currPosition.y;
			int k = currPosition.cK;
			int a = currPosition.a;
          
			if(x == H-1 && y == W-1) {
				result = Math.min(a, result);
			}
				
			if(k > 0) { // k 횟수가 남아있으면 horse 행동
				
				for(int h=0; h<horseDrc.length; h++) {
					int hX = x + horseDrc[h][0];
					int hY = y + horseDrc[h][1];
					
					if(hX >= 0 && hX < H && hY >= 0 && hY < W 
							&& map[hX][hY] != 1 // 장애물 놓여있으면 이동 불가
							&& !isVisited[hX][hY][k-1][1]) {
						isVisited[hX][hY][k-1][1] = true;
						dq.add(new Position(hX, hY, k-1, a+1));
					}
				}
			}
				
			// k의 개수와는 관계 없이 monkey 행동도 진행
			for(int m=0; m<monkeyDrc.length; m++) {
				int mX = x + monkeyDrc[m][0];
				int mY = y + monkeyDrc[m][1];
					
				if(mX >= 0 && mX < H && mY >= 0 && mY < W 
						&& map[mX][mY] != 1 // 장애물 놓여있으면 이동 불가
						&& !isVisited[mX][mY][k][0]) {
					isVisited[mX][mY][k][0] = true;
					dq.add(new Position(mX, mY, k, a+1));
				}
			}
			
		}
		bw.write((result == Integer.MAX_VALUE ? -1 : result) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}