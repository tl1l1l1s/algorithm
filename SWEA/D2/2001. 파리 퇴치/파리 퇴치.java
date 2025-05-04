import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] flies = new int[N][N];
			int[][] sum = new int[N+1][N+1];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					flies[i][j] = Integer.parseInt(st.nextToken());
					}
			}
			
			for(int i=0; i<N; i++) {
				sum[0][i] = 0;
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					sum[i][j] = flies[i-1][j-1] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
				}
			}
			
			int result = 0;
			
			for(int i=M; i<=N; i++) {
				for(int j=M; j<=N; j++) {
					result = Math.max(result, 
							sum[i][j] - sum[i-M][j] - sum[i][j-M] + sum[i-M][j-M]);
				}
			}
			 bw.write("#" + test_case + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

    }
}