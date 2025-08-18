import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static Node swan1, swan2;
	static int[][] drc = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};	
	static int[] parent;
	static boolean[][] isVisited;
	
	static class Node {
		int x; int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b) {
			parent[b] = a;
		} else parent[a] = b;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// R개의 행 * C개의 열
		// 가로세로 중 한 면이 물일 경우 빙판이 녹음
		// . == 물, X == 빙판,  L == 백조
		// 백조들이 며칠이 지나야 만날 수 있는지
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		parent = new int[R*C];
		isVisited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				parent[i*C + j] = i*C + j;
				if(map[i][j] == 'L') {
					if(swan1 == null) {
						swan1 = new Node(i, j);
					} else swan2 = new Node(i, j); 
				}
			}
		}
		
		int result = 0;
		Queue<Node> q = new ArrayDeque<>();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != 'X') { // 빙판이 아닌 경우
					for(int k=0; k<4; k++) {
						int nX = i+drc[k][0];
						int nY = j + drc[k][1];
						if(nX >= 0 && nX < R
								&& nY >= 0 && nY < C) {
							if(map[nX][nY] != 'X') {
								union(i*C + j, (nX)*C + nY);
							} else if(map[nX][nY] == 'X' && !isVisited[nX][nY]) {
								q.add(new Node(nX, nY));
								isVisited[nX][nY] = true;
							}
						}
					}
				}
					
			}
		}
		
		while(find(swan1.x * C + swan1.y) != find(swan2.x * C + swan2.y) ) {	
			isVisited = new boolean[R][C]; // 방문 배열 초기화
    		Queue<Node> nQ = new ArrayDeque<>(); // 다음에 녹을 빙판 위치
    		
    		while(!q.isEmpty()) {
    			Node temp = q.poll();
    			int x = temp.x;
    			int y = temp.y;
    			
    			map[x][y] = '.';
    			for(int k=0; k<4; k++) {
    				int nr = x + drc[k][0];
    				int nc = y + drc[k][1];
    				
    				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
    				
    				if(map[nr][nc] == '.' || map[nr][nc] =='L') { // 물인 경우 통합
    					union(x * C + y, nr * C + nc);
    				}
    				else if(map[nr][nc] == 'X' && isVisited[nr][nc] == false) {
    					nQ.add(new Node(nr, nc));
    					isVisited[nr][nc] = true;
    				}
    			}
    		}
    		q = nQ;
    		result += 1;
    	}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}