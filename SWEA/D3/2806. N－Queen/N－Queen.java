import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] drc = {{-1, 0}, // 위 확인
			{-1, 1},  // 우상 대각선 확인
			{-1, -1}}; // 좌상 대각선 확인
	static int N;
	static boolean[][] map;
	static int result;
	
	static void solution(int cR) {
		if(cR == N) { // 끝에 도달했다 = 문제 없이 끝냈다
			result++;
			return;
		}
		
		// 1부터 들어온다
		for(int i=0; i<N; i++) {
			map[cR][i] = true;
			if(checkAvailability(cR, i)) {
				solution(cR+1); // true일 때만 다음 row로 넘어가게
			}
			map[cR][i] = false;
		}
	}
	
	static boolean checkAvailability(int x, int y) {
		int cX;
		int cY;
		
		for(int i=0; i<3; i++) {
			cX = x + drc[i][0];
			cY = + y + drc[i][1];

			while(cX >= 0 && cX < N && cY >=0 && cY < N) {
				if(map[cX][cY]) {
					return false;
				}
				cX += drc[i][0];
				cY += + drc[i][1];
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			// 구현을 어떻게 할 거냐면 가로에 하나씩 놓는 것을 전제로 함
			// 그 다음에, 어차피 하나만 가로에 놓을 거니까 오른쪽 서치 X
			// 위만 확인. 그리고 오른쪽 위 대각선/ 왼쪽위 대각선 확인
			map = new boolean[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(map[i], false);
			}
			
			if(N == 1) {
				result = 1;
			} else {
				result = 0;
				for(int i=0; i<N; i++) {
					map[0][i] = true;
					solution(1);
					map[0][i] = false;
				}
			}
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}