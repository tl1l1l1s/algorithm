import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] drc = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 대신고 본관
		// N층 1반 2반 3반 ... N반
		// 1층 1반 2반 3반 ... N반
		
		// 공사 - 상하좌우 반 영향
		// 층수 낮은 층 + 반 번호 작은 반
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[][] classes = new int[5][N+1];
		
		int rR = 0, rF = 1, rC = 1; // result floor/class
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			if(Integer.parseInt(st.nextToken()) == 1) {
				int f = Integer.parseInt(st.nextToken()); // floor
				int c = Integer.parseInt(st.nextToken()); // class
				
				classes[f][c] += 1;
				for(int d=0; d<4; d++) {
					int nF = f + drc[d][0]; // next floor
					int nC = c + drc[d][1]; // next class
					
					if(nF > 0 && nF <= 4 && nC > 0 && nC <= N) {
						classes[nF][nC] += 1;
					}
				}
			} else {
				int f = Integer.parseInt(st.nextToken()); // floor
				int trR = 0, trC = 1;
				
				for(int c=1; c<=N; c++) {
					if(trR < classes[f][c]) {
						trR = classes[f][c];
						trC = c;
					}
				}
				bw.write(trC + "\n");
			}
		}
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=N; j++) {
				if(rR < classes[i][j]) {
					rR = classes[i][j];
					rF = i;
					rC = j;
				}
			}
		}
		
		bw.write(rF + " " + rC + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}