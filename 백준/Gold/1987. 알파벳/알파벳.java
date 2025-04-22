import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;
	static boolean[] visited = new boolean[26];
	
	static int dfs(int row, int col, int count) {
		int result = count;		
		visited[board[row][col] - 'A'] = true;
    
        if(row - 1 >= 0) {
			if(!visited[board[row-1][col] - 'A']) {
				result = Math.max(result, dfs(row-1, col, count+1));
			}
		}
		if(col - 1 >= 0) {
			if(!visited[board[row][col-1] - 'A']) {
				result = Math.max(result, dfs(row, col-1, count+1));
			}
		}
		if(row + 1 < board.length) {
			if(!visited[board[row+1][col] - 'A']) {
				result = Math.max(result, dfs(row+1, col, count+1));
			}
		}
		if(col + 1 < board[0].length) {
			if(!visited[board[row][col+1] - 'A']) {
				result = Math.max(result, dfs(row, col+1, count+1));
			}
		}
		visited[board[row][col] - 'A'] = false;
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			
			for(int j=0; j<C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		Arrays.fill(visited, false);
		bw.write(dfs(0, 0, 1) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}