import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] isVisited;
	static boolean isPossible;
	
	static void sol(int x, int y) {
		if(map[x][y] == -1) {
			isPossible = true;
			return;
		}
		
		isVisited[x][y] = true;
		int k = map[x][y];
		if(x+k < N) {
			if(!isVisited[x+k][y]) {
				sol(x+k, y);
			}
		}
        if(y+k < N) {
			if(!isVisited[x][y+k]) {
				sol(x, y+k);	
			}
		}
		isVisited[x][y] = false;
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 쩰리 - 점프
		// 정사각형의 내부에서만 움직이며 외부 -> 즉시 패배
		// 제일 왼쪽 위에서 출발 (오른쪽, 아래만 이동 가능)
		// 가장 아래 칸 -> ok
		// 한번에 이동할 수 잇는 칸의 수는 현재 밟고 잇는 칸에쓰여잇는 수만큼
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isPossible = false;
		isVisited = new boolean[N][N];
		
		isVisited[0][0] = true;
		sol(0, 0);
		bw.write(isPossible ? "HaruHaru" : "Hing" + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
