import java.io.*;
import java.util.*;

public class Main {
	static final int[][] drc = {{1, 0} ,{-1, 0}, 
			{0, 1}, {0, -1}};
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	public static int solution(int r, int c) {
		int cnt = 1;
		
		visited[r][c] = true;
		for(int i=0; i<4; i++) {
			int nR = r + drc[i][0];
			int nC = c + drc[i][1];
			
			if(nR >= 0 && nR < N
					&& nC >= 0 && nC < N) {
				if(visited[nR][nC] || map[nR][nC] == 0) continue;
				
				cnt += solution(nR, nC);
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.valueOf(line.charAt(j)) - '0';
				visited[i][j] = false;
			}
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		int cnt;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					cnt = solution(i, j);
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		bw.write(result.size() + "\n");
		for(int i=0; i<result.size(); i++) {
			bw.write(result.get(i) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}