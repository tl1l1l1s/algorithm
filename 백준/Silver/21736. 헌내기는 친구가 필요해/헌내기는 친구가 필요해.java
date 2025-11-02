import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] dr = {
			{0, 1}, {1, 0},
			{-1, 0}, {0, -1},
	};
	static int result;
	static int N;
	static int M;
	static String[] map;
	static boolean[][] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		result = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N];
		isVisited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine();
			Arrays.fill(isVisited[i], false);
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i].charAt(j) == 'I') {
					dfs(i, j);
					break;
				}
			}
		}
		
		if(result == 0) {
			bw.write("TT\n");
		} else bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}
	
	static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int currX = x + dr[i][0];
			int currY = y + dr[i][1];
				
			if(currX >= 0 && currX < N
					&& currY >= 0 && currY < M
					&& !isVisited[currX][currY]
					&& map[currX].charAt(currY) != 'X') {
				
					isVisited[currX][currY] = true;
					if(map[currX].charAt(currY) == 'P') result++;
					dfs(currX, currY);
			
			}
				
		}
	}

}