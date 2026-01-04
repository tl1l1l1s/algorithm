import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] drc = {
			{0, 1}, {0, -1}, {1, 0}, {-1, 0}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 설치 (X로 설치)
		// 터뜨리기 (O boom -> 기존 X O로 변경)
		int n = 2;
		while(n <= N) {
			
			if(n % 2 == 0) { // 설치
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j] == '.') map[i][j] = 'X';
					}
				}
			} else {
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j] == 'O') {
							map[i][j] = '.';
							 for(int k=0; k<4; k++) {
								 int nX = i + drc[k][0];
								 int nY = j + drc[k][1];
								 
								 if(nX >= 0 && nX < R && nY >= 0 && nY < C) {
									 if(map[nX][nY] != 'O') map[nX][nY] = '.';	 
								 }
							 }
						}
					}
				}
				
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j] == 'X') {
							map[i][j] = 'O';
						}
					}
				}
			}
			n++;
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				bw.write(map[i][j] == 'X' ? 'O' : map[i][j]);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}