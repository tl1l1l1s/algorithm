import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// i줄은 원소가 i+1개 존재
		// 0번째, i번째일 때는 1
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					if(j==0) {
						map[i][0] = 1;
					}else if(i==j) {
						map[i][j] = 1;
					} else {
						map[i][j] = map[i-1][j-1] + map[i-1][j];
					}
				}
			}
			
			bw.write("#" + tc + "\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					bw.write(map[i][j] + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}