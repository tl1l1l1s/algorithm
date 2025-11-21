import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] cave;
	static int[][] rupee;
	static int[][] drc = {
			{0, 1}, {1, 0},
			{0, -1}, {-1, 0}
	};
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int rp;
		
		Node(int x, int y, int rp) {
			this.x = x;
			this.y = y;
			this.rp = rp;
		}
		
		
		@Override
		public int compareTo(Node o) {
			return this.rp - o.rp;
		}
	}
	
	static void dijkstra() {
		rupee = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(rupee[i], (int)1e6);
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, cave[0][0]));
		
		while(!pq.isEmpty()) {
			Node nd = pq.poll();
			
			if(rupee[nd.x][nd.y] < nd.rp) continue;
			for(int d=0; d<4; d++) {
				int nX = nd.x + drc[d][0];
				int nY = nd.y + drc[d][1];

				if(nX >= 0 && nX < N && nY >= 0 && nY < N
						&& (nd.rp + cave[nX][nY]) < rupee[nX][nY]) {
					rupee[nX][nY] = nd.rp + cave[nX][nY];
					pq.add(new Node(nX, nY, rupee[nX][nY]));
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int pN = 1;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			cave = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			dijkstra();
			bw.write("Problem " + pN + ": " + rupee[N-1][N-1] + "\n");
			pN++;
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}