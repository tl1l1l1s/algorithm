import java.io.*;
import java.util.*;

public class Main {
	
	static final int[][] drc = {
			{0, 1}, {1, 0}, 
			{-1, 0},{0, -1},
	};
	static int N;
	static int M;
	static int[][] maze;
	static boolean[][] visited;
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void solution() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			for(int i=0; i<4; i++) {
				int nX = curr.x + drc[i][0];
				int nY = curr.y + drc[i][1];
					
				if(nX >= 0 && nX < N
						&& nY >= 0 && nY < M) {
					if(maze[nX][nY] != 1 || visited[nX][nY]) continue;

					visited[nX][nY] = true;
					maze[nX][nY] = maze[curr.x][curr.y] + 1;
					q.add(new Node(nX, nY));
				}
			}
		}
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				visited[i][j] = false;
				maze[i][j] = Integer.valueOf(line.charAt(j)) - '0'; 
			}
		}

		solution();
		bw.write(maze[N-1][M-1] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}