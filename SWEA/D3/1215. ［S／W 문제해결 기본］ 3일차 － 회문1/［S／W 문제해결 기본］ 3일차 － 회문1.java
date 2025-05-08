import java.util.*;
import java.io.*;

class Solution
{
    	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		StringBuilder sb2;
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] board = new char[8][8];
			int result = 0;
			
			for(int i=0; i<8; i++) {
				board[i] = br.readLine().toCharArray();
			}
			 
			for(int i=0; i<8; i++) { // 0~8까지 기본 순회
				for(int j=0; j<=8-N; j++) { // 8-N까지만 순회
					sb = new StringBuilder();
					sb2 = new StringBuilder();
					
					// N번 더한다
					for(int k=0; k<N; k++) {
						sb.append(board[i][j+k]);
						sb2.append(board[j+k][i]);
					}
					
					if(sb.toString().equals(sb.reverse().toString())) {
						result++;
					}
					if(sb2.toString().equals(sb2.reverse().toString())) {
						result++;
					}
				}
			}
		
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}