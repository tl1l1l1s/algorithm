import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int N = Integer.parseInt(br.readLine());
			int[][] snail = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					snail[i][j] = 0;
				}
			}
			
			int curr = 1;
			int top = 0, bottom = N-1, left = 0, right = N-1;
			while(curr <= N*N) {
				// 오른쪽으로 이동하려 할 때 left ~ right까지 이동
				for(int i=left; i<=right; i++) { 
					snail[top][i] = curr++;
				}
				top++; // 이후 1,0 -> 2,0 -> ... -> N-1, 0까지 가야하므로 한 층 줄이기
				
				// 아래로 내려갈 때 top ~ bottom 이동
				for(int i=top; i<=bottom; i++) {
					snail[i][right] = curr++;
				}
				right--; // right 제한 -1
				
				
				if(top <= bottom) {
					// 왼쪽으로 이동할 때 bottom을 하나씩 줄여가며 이동
					for(int i=right; i>=left; i--) {
						snail[bottom][i] = curr++;
					}
					bottom--;
				}
				
				if(left<=right) {
					for(int i=bottom; i>=top; i--) {
						snail[i][left] = curr++;
					}
					left++;
				}
			}
			
			bw.write("#" + test_case + " " + "\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					bw.write(snail[i][j] + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}