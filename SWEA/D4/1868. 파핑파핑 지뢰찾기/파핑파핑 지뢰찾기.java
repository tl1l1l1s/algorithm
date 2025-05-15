import java.io.*;
import java.util.*;

class Solution {
	static final int[][] drc = {
			{1, 0}, {-1, 0},
			{0, 1}, {0, -1},
			{1, 1}, {-1, 1},
			{1, -1}, {-1, -1},
	};
	static BufferedWriter bw;
	static int[][] temp;
	static boolean[][] visited;
	static int N;
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for(int k=0; k<8; k++) {
				int nX = curr[0] + drc[k][0];
				int nY = curr[1] + drc[k][1];
				
				if(nX >= 0 && nX < N && nY >= 0 && nY < N && !visited[nX][nY]) {
					visited[nX][nY] = true;
					if(temp[nX][nY] == 0) {
						q.offer(new int[] {nX, nY});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 지뢰 = *, 없으면 = .
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			char[][] board = new char[N][N];
			temp = new int[N][N];
			for(int i=0; i<N; i++) {
				board[i] = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					temp[i][j] = 0;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j] == '*') {
						temp[i][j] = -1; // 지뢰 있는 곳 -1 표시
						
						for(int k=0; k<8; k++) { // 지뢰 근처
							int nX = i + drc[k][0];
							int nY = j + drc[k][1];
							
							if(nX >= 0 && nX < N && nY >= 0 && nY < N) {
								if(temp[nX][nY] != -1) { // 지뢰가 있는 곳만 제외하고 ++
									temp[nX][nY]++;
								}
							}
						}
					}
				}
			}
		
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = false;
				}
			}

			int count = 0;
			// 0과 주위 부분을 그룹화하여 1로 카운트
				// BFS 사용, 0 주위 싹 다 큐에 넣고 돌면서 확인
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j] == 0 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}

			// 카운트 한 뒤 남은 1,2,3,...,들을 카운트하여 반환
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j] > 0 && !visited[i][j]) {
						count++;
					}
				}
			}
			
			bw.write("#" + tc + " " + count + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}