import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[][] sudoku = new int[9][9];
		int T = Integer.parseInt(br.readLine()); 

		for(int tc = 1; tc <= T; tc++) {
			
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 1;
			int bitmask;  
			int subBitmask; 
			for(int i=0; i<9; i++) {
				bitmask = 0;
				subBitmask = 0;
				
				for(int j=0; j<9; j++) { // 세로, 가로 비트마스킹 검증
					bitmask = bitmask | (1 << (sudoku[i][j]-1));
					subBitmask = subBitmask | (1 << (sudoku[j][i]-1));
				}
				
				// 비트마스킹 검증을 위해 0b를 붙여서 십진수가 아님을 미리 작성
				if(bitmask != 0b111111111 || subBitmask != 0b111111111) {
					result = 0; break;
				}
			}
			
			subgrid: // 반복문 탈출을 위해 레이블을 사용
			if(result != 0) { // 3*3 그리드 확인용
				for(int x=0; x<3; x++) {
					for(int y=0; y<3; y++) {
						bitmask = 0;
						for(int i=x*3; i<x*3+3; i++) {
							for(int j=y*3; j<y*3+3; j++) {
								bitmask = bitmask | (1 << (sudoku[i][j]-1));
							}
						}
						if(bitmask != 0b111111111) {
							result = 0; break subgrid;
						}
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