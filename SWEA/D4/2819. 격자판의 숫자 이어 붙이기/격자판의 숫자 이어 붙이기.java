import java.io.*;
import java.util.*;

class Solution {
	
	static final int[][] drc = {
			{1, 0}, {-1, 0},
			{0, 1}, {0, -1},
	};
	static int[][] board;
	static HashSet<String> set;
	
	static void solution(int x, int y, String str) {
		if(str.length() == 7) {
			set.add(str);
			return;
		}

		for(int k=0; k<4; k++) {
			int nX = x + drc[k][0];
			int nY = y + drc[k][1];
			
			if(nX >= 0 && nX < 4 && nY >= 0 && nY < 4) {
				solution(nX, nY , str + board[nX][nY]);
			}
		}
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 4x4 격자판, 0~9까지의 숫자가 적혀있음
		// 동서남북 네 방향으로 총 여섯 번 이동하며 차례대로 이어 붙이면 7자리의 숫자
		// 격자칸을 다시 거쳐도 됨
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			set = new HashSet<String>();
			board = new int[4][4];
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					solution(i, j, "");
				}
			}
			bw.write("#" + tc + " " + set.size() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}