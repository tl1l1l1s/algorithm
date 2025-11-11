import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int[][] drx = {{0, 1} ,{1, 0},
			{0, -1}, {-1, 0}};
	
	static class Node implements Comparable<Node>{
		int dist;
		int x;
		int y;
		
		Node(int d, int x, int y) {
			this.dist = d;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	static void solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(dist[curr.x][curr.y] < curr.dist) continue;
			for(int z=0; z<4; z++) {
				int cX = curr.x + drx[z][0];
				int cY = curr.y + drx[z][1];
				
				if(cX >= 0 && cX < N
						&& cY >= 0 && cY < N) {
					if(dist[cX][cY] > curr.dist + map[cX][cY]) {
						dist[cX][cY] = curr.dist + map[cX][cY];
						pq.add(new Node(dist[cX][cY], cX, cY));
					}
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			dist = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String l = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = l.charAt(j) - '0';
					visited[i][j] = false;
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dist[0][0] = 0;
			solution();
			bw.write("#" + tc + " " + dist[N-1][N-1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}