import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb;
	static int N;
	static int[][] vid;
	
	private static void sol(int x, int y, int size) {
		if(check(x, y, size)) {
			sb.append(vid[x][y]);
			return;
		}
		
		sb.append("(");
		sol(x, y, size/2);
		sol(x, y + size/2, size/2);
		sol(x + size/2, y, size/2);
		sol(x + size/2, y + size/2, size/2);
		sb.append(")");
	}
	
	private static boolean check(int x, int y, int size) {
		int p = vid[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(vid[i][j] != p) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 흑백 영상을 압축하여 표현하는 데이터 구조
		// 흰 = 0. 검 = 1 , 2차원 배열
		// 왼위, 오위, 왼아, 오아를 나누어 압축하고 괄호 안에 묶어 표현 
		// 압축 결과를 표현 
		N = Integer.parseInt(br.readLine());
		vid = new int[N+1][N+1];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				vid[i][j] = str.charAt(j) - '0';
			}
		}
		
		sol(0, 0, N);
		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}