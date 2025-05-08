// 델타 탐색
import java.util.*;
import java.io.*;

class Solution
{
	static int[][] drc = {
			{1, -1}, // 좌측 하향 대각선
			{1, 0}, // 하향
			{1, 1}, // 우측 하향 대각선
			{0, 1} // 우향
			};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// NXN 크기의 판
		// 돌 = o, 아니면 = .
		// 가로, 세로, 대각선 중 하나의 방향으로 돌 다섯 개 이상 연속 판정
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] board = new String[N];
			
			for(int i=0; i<N; i++) {
				board[i] = br.readLine();
			}
			
			boolean result = false;
			
			outer:
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i].charAt(j) == 'o') {
						for(int k=0; k<4; k++) { // 세로 가로 대각선 방향 확인 
							int count = 0;
							
							f:
							for(int l=0; l<4; l++) { // 4번 반복
								int ni = i + drc[k][0] * (l+1);
								int nj = j + drc[k][1] * (l+1);
								
								if(ni >= 0 && ni < N
										&& nj >= 0 && nj < N
										&& board[ni].charAt(nj) == 'o') {
									count++; // 조건 확인 후 맞으면 ++
								} else {
									break f;
								}
								
								if(count >= 4) { // 5 이상인 경우 outer 탈출
									result = true;
									break outer;
								}
							}
						}
					}
				}
			}
			bw.write("#" + tc + " " + (result ? "YES" : "NO") + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}