import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] drc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int N;
	static int D;
	static char[][] map;
	static int[][] visited;
	static int result;
	
	static class Node {
		int x;
		int y;
		int health;
		int um;
		int count;
		
		Node(int x, int y, int health, int um, int count) {
			this.x = x;
			this.y = y;
			this.health = health;
			this.um = um;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 가로 N, 세로 N 
		// 현재 지대(S), 안전 지대(E) 제외한 모든 곳에 비
		// 상하좌우 이동
		// 우산(U) 내구도 1 감소, 우산 없으면 체력 1 감소
			// 가지고 있는 우산 반드시 버림
		// 우산 내구도 0 = 우산 X
		// 체력 0 = 유저 X
		
		N = Integer.parseInt(st.nextToken()); // 격자 한 변의 길이
		int H = Integer.parseInt(st.nextToken()); // 현재 체력
		D = Integer.parseInt(st.nextToken()); // 우산 내구도
		map = new char[N][N];
		visited = new int[N][N];

		int sX = 0, sY = 0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'S') { // 시작점 기록
					sX = i; sY = j;
				}
			}
		}
		
		result = Integer.MAX_VALUE;
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(sX, sY, H, 0, 0));
		visited[sX][sY] = H + 0;
		
		while(!q.isEmpty()) {
			Node currNode = q.poll();
			
			int x = currNode.x;
			int y = currNode.y;
			int health = currNode.health;
			int um = currNode.um;
			int count = currNode.count;
			
			if(visited[x][y] > health + um) {
				continue;
			}
			
			if(map[x][y] == 'E') {
				result = Math.min(result, count);
				break;
			}
			
			for(int k=0; k<4; k++) {
				int nX = x + drc[k][0];
				int nY = y + drc[k][1];
				
				if(nX >= 0 && nX < N
						&& nY >= 0 && nY < N) {
					
					int nHealth = health;
					int nUm = um;
					
					if(map[nX][nY] == 'U') {
						nUm = D;
					}
					
					if(map[nX][nY] != 'E') {
						if(nUm > 0) {
							nUm -= 1;
						} else {
							nHealth -= 1;
						}
					}
					
					if(nHealth == 0) {
						continue;
					}

					
					if(visited[nX][nY] < nHealth + nUm) {
						visited[nX][nY] = nHealth + nUm;
						q.add(new Node(nX, nY, nHealth, nUm, count + 1));
					}
				}
			}
		}
		
		bw.write((result == Integer.MAX_VALUE ? -1 : result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}