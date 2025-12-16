import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] drc = {
			{0, 1}, {1, 0},
			{0, -1}, {-1, 0}
	};
	static boolean[][] isVisited;
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean isValid(int i, int j, int k) {
		int x = i + drc[k][0];
		int y = j + drc[k][1];
		if(x >= 0 && x < N
				&& y >= 0 && y < N
				&& !isVisited[x][y]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 적록색약
		// R G B
		// 상하좌우로 인접해있는 경우 하나의 구역 취급
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		isVisited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(isVisited[i], false);
		}
		
		Queue<Node> q = new ArrayDeque<>();
		// 일반인
		int nR = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(!isVisited[i][j]) {
					q.add(new Node(i, j));
					isVisited[i][j] = true;
					nR += 1;
				}
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					int cX = node.x;
					int cY = node.y;
					
					for(int k=0; k<4; k++) {
						if(isValid(cX, cY, k)
								&& map[cX + drc[k][0]][cY + drc[k][1]] == map[cX][cY]) {
							q.add(new Node(cX + drc[k][0], cY + drc[k][1]));
							isVisited[cX + drc[k][0]][cY + drc[k][1]] = true;
						}
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) { // 초기화
			Arrays.fill(isVisited[i], false);
		}
		// 적록색맹
		int uR = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(!isVisited[i][j]) {
					q.add(new Node(i, j));
					isVisited[i][j] = true;
					uR += 1;
				}
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					int cX = node.x;
					int cY = node.y;
					
					for(int k=0; k<4; k++) {
						if(isValid(cX, cY, k)) {
							if(map[cX + drc[k][0]][cY + drc[k][1]] == map[cX][cY]
								|| (map[cX][cY] == 'R' && map[cX + drc[k][0]][cY + drc[k][1]] == 'G')
								|| (map[cX][cY] == 'G' && map[cX + drc[k][0]][cY + drc[k][1]] == 'R')) {
								q.add(new Node(cX + drc[k][0], cY + drc[k][1]));
								isVisited[cX + drc[k][0]][cY + drc[k][1]] = true;
							}
						}
					}
				}
			}
		}
		
		bw.write(nR + " " + uR + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}