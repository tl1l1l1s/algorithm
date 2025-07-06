import java.io.*;
import java.util.*;

public class Main {
	static int[][] drc = {
			{1, 0}, {0, 1},
			{-1, 0}, {0, -1},
	};
	
	static int N;
	static int M;
	static int[][] sea;
	static int[][] tempSea;
	static boolean[][] memo;

	static boolean isSeparated() {
		int count = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!memo[i][j] && sea[i][j] != 0) {
					memo[i][j] = true;
					count += check(i, j);
					if(count > 1) return true;
				}
			}
		}
		return false;
	}
	
	static int check(int x, int y) {
		for(int k=0; k<4; k++) {
			int cX = x + drc[k][0];
			int cY = y + drc[k][1];
			if(cX >= 0 && cX < N
					&& cY >= 0 && cY < M
					&& !memo[cX][cY]
					&& sea[cX][cY] != 0) {
				memo[cX][cY] = true;
				check(cX, cY);
			}
		}
		
		return 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 두 덩이 이상으로 분리되는 최초의 시간
		// 주위 바다(=0) 개수만큼 줄어들음
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sea = new int[N][M];
		tempSea = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		
		while(true) {
			tempSea = new int[N][M];
			memo = new boolean[N][M];

		    // 빙산이 남아있는지 먼저 확인
		    boolean hasIceberg = false;
		    for(int i=0; i<N && !hasIceberg; i++) {
		        for(int j=0; j<M && !hasIceberg; j++) {
		            if(sea[i][j] != 0) {
		                hasIceberg = true;
		            }
		        }
		    }
		    
		    if(!hasIceberg) {
		        bw.write("0\n");
		        break;
		    }
			
			if(isSeparated()) {
				bw.write(result + "\n");
				break;
			}
			
			// tempSea에 빼야 할 숫자 저장
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(sea[i][j] != 0) {
						
						for(int k=0; k<4; k++) {
							int cX = i + drc[k][0];
							int cY = j + drc[k][1];

							if(cX >= 0 && cX < N
									&& cY >= 0 && cY < M
									&& sea[cX][cY] == 0) {
								tempSea[i][j] += 1;
							}
						}
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					sea[i][j] = sea[i][j] - tempSea[i][j];
					if(sea[i][j] < 0) sea[i][j] = 0;
				}
			}
			result++;
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}