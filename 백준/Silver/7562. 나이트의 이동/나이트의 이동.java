import java.io.*;
import java.util.*;

public class Main {
	
	static final int[][] drc = { // 나이트가 이동했을 경우 X, Y 변화
			{-2, -1}, {-2, 1},
			{2, -1}, {2, 1},
			{1, 2}, {-1, 2},
			{1, -2}, {-1, -2},
	};
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int I = Integer.parseInt(br.readLine());
			
			int[][] visited = new int[I][I];
			for(int i=0; i<I; i++) {
				for(int j=0; j<I; j++) {
					visited[i][j] = -1;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int currX = Integer.parseInt(st.nextToken());
			int currY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int targetX = Integer.parseInt(st.nextToken());
			int targetY = Integer.parseInt(st.nextToken());
			
			// BFS를 사용하여 순회
			Queue<Node> q = new LinkedList<Node>();
			q.add(new Node(currX, currY));
			visited[currX][currY] = 0;
			
			outer:
			while(!q.isEmpty()) {
				Node curr = q.poll();
				
				if(curr.x == targetX && curr.y == targetY) {
					break outer;
				}
				
				for(int i=0; i<8; i++) {
					int nX = curr.x + drc[i][0];
					int nY = curr.y + drc[i][1];
					
					if(nX >= 0 && nX < I
							&& nY >= 0 && nY < I) {
						if(visited[nX][nY] != -1) continue; // 초기값이 아닌 경우 = 방문하였으므로 패스
						
						visited[nX][nY] = visited[curr.x][curr.y] + 1;
						q.add(new Node(nX, nY));
					}
				}
			}
			
			bw.write(visited[targetX][targetY] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}