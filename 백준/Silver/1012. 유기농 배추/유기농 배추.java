import java.io.*;
import java.util.*;

public class Main {
	static int M; // 가로
	static int N; // 세로
	static int[][] field;
	static boolean[][] visited;
	static int[][] drc = {
			{1, 0}, {-1, 0},
			{0, 1}, {0, -1},
	};
	
	static int solution(int x, int y) {
		if(visited[x][y] || field[x][y] == 0) return 0;
		
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nX = x + drc[i][0];
			int nY = y + drc[i][1];
		
			if(nX >= 0 && nX < M
					&& nY >= 0 && nY < N
					&& field[nX][nY] == 1) {
				solution(nX, nY);
			}
		}
		return 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 상하좌우에 존재 = 배추흰지렁이가 근처에 1 있는 데를 다 도와줄 수 있음
		// 대각선으로 연결된 경우 제외하고 상하좌우로 연결된 배추들 = 1
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new int[M][N];
			visited = new boolean[M][N];
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					field[i][j] = 0;
					visited[i][j] = false;
				}
			}
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			int result = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					result += solution(i, j);
				}
			}
			bw.write(result + "\n");	
		}

		bw.flush();
		bw.close();
		br.close();

	}

}