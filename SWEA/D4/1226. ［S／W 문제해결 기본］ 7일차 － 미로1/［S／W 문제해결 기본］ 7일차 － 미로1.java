import java.io.*;
import java.util.*;

class Solution {
	
	static final int[][] drc = {
			{-1, 0}, {0, -1}, 
			{1, 0}, {0, 1}
	};
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[][] maze;
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 미로는 16*16 행렬 형태
		// 0 = 길, 1 = 벽, 2 = 출발점, 3 = 도착점
		// 출발점에서 도착점 갈 수 있는지 여부를 1 = 가능함, 0 = 불가능함
		
		for(int tc=1; tc<=10; tc++) {
			int test_case = Integer.parseInt(br.readLine());
			maze = new int[16][16];
			
			int startX = 15;
			int startY = 15;
			
			for(int i=0; i<16; i++) {
				String line = br.readLine();
				for(int j=0; j<16; j++) {
					maze[i][j] = line.charAt(j) - '0';
					if(maze[i][j] == 2) {
						startX = i; startY = j;
					}
				}
			}
			
			int result = 0;
			Queue<Node> q = new LinkedList<Node>();
			q.add(new Node(startX, startY));
			maze[startX][startY] = 1;
			outer:
			while(!q.isEmpty()) {
				Node curr = q.poll();
				
				for(int i=0; i<4; i++) {
					int nX = curr.x + drc[i][0];
					int nY = curr.y + drc[i][1];
					
					if(nX >= 0 && nX < 16
							&& nY >= 0 && nY < 16) {
						if(maze[nX][nY] == 0) { // 0일 때만 이동
							q.add(new Node(nX, nY));
							maze[nX][nY] = 1; // 중복 방지를 위해 1로 변경
						} else if(maze[nX][nY] == 3) { // 2일 때는 이동 X, 즉시 리턴
							result = 1;
							break outer;
						}
					}
				}
			}
			
			bw.write("#" + test_case + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}