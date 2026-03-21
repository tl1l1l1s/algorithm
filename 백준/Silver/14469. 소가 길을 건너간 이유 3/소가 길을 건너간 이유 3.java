import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// 도착 순서대로 정렬
		// 도착 시각 + 검문 시간 ( - 마지막 소 검문 시간)
		int[][] cows = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			cows[i][0] = Integer.parseInt(st.nextToken()); // 도착
			cows[i][1] = Integer.parseInt(st.nextToken()); // 검문
		}
		
		Arrays.sort(cows, (a, b) -> Integer.compare(a[0], b[0]));
		
		int result = cows[0][0] + cows[0][1];
		for(int i=1; i<N; i++) {
			
			if(result < cows[i][0]) {
				result = cows[i][0];
			}
				
			result += cows[i][1];
		}
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}