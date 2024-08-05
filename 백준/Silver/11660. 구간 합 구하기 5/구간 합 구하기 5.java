import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] nums = new int[N+1][N+1];
		int[][] sum = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + nums[i][j];
			}
		}
		
		int x1, y1, x2, y2;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
		}
		
		
		br.close();
	}

}
