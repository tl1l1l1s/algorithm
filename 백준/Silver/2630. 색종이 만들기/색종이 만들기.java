import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int blue;
	static int white;
	
	private static void sol(int x, int y, int size) {
		if(check(x, y, size)) {
			if(arr[x][y] == 1) {
				blue++;
			} else white++;
			return; 
		}
		
		sol(x, y, size/2);
		sol(x, y+size/2, size/2);
		sol(x+size/2, y, size/2);
		sol(x+size/2, y+size/2, size/2);
	}
	
	private static boolean check(int x, int y, int size) {
		int v = arr[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(arr[i][j] != v) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 파란색이면 1 하얀색이면 0
		// N*N개
		// N/2개가 전원 파란색 = 1 하나로 퉁침
		// 1, 0 개수 구하기
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		blue = 0;
		white = 0;
		sol(0, 0, N);
		bw.write(white + "\n" + blue);

		bw.flush();
		bw.close();
		br.close();

	}

}