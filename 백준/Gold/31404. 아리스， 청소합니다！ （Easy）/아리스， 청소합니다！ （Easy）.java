import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] drc = {
			{-1, 0}, // 0 = 상
			{0, 1}, // 1 = 우
			{1, 0}, // 2 = 하
			{0, -1} // 3 = 좌
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// H*W 게임개발부 부실 청소
	    // (r, c) = (0, 0) ~ (H-1, W-1)

	    // 모든 칸에는 먼지 존재
	    // 규칙표를 따름 (현재 좌표에 적힌 만큼 시계방향 회전)
	        // 먼지 제거했다면 규칙표 A 참고
	        // 먼지 미제거했다면 규칙표 B 참고
	    // 반복 시 먼지 제거 X 혹은 영역 밖 -> 중지

		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[H][W];
		int[][] B = new int[H][W];
		boolean[][] isCleaned = new boolean[H][W];
		int[][][] isVisited = new int[H][W][4];
		
		for(int i=0; i<H; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<H; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = 0;
		int dummy = 0;
		int ver = 0; // 먼지 청소 후 배열 초기화를 위한 버전 처리 변수
		int r = R;
		int c = C;
		int d = D;
		while(true) {
			if(r >= 0 && r < H && c >= 0 && c < W) {
				if(!isCleaned[r][c]) { // 먼지 존재, 규칙표 A 참고
					isCleaned[r][c] = true;
					result++;
					ver++;
					dummy = 0;
					d = (d + A[r][c]) % 4;

					r += drc[d][0];
					c += drc[d][1];
				} else { // 먼지 없음, 규칙표 B 참고
					if(isVisited[r][c][d] == ver) { // 방문 완료
						break;
					}
					
					isVisited[r][c][d] = ver;
					result++;
					dummy++;
					d = (d + B[r][c]) % 4;
					r += drc[d][0];
					c += drc[d][1];
				}
			} else { // 영역 외
				break;
			}
		}

		bw.write(result - dummy + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}
