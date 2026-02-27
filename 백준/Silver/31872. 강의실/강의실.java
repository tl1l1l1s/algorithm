import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N+1];
		
		A[0] = 0;
		for(int n=1; n<=N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		// K번 순간 이동 가능
		// 들리는 데 걸리는 최소 시간
		
		// 강의실의 거리 차가 제일 큰 것부터 순서대로 순간이동 사용
		
		int[] diff = new int[N+1];
		for(int n=1; n<=N; n++) {
			diff[n] = A[n] - A[n-1];
		}
		Arrays.sort(diff);
		
		int result  = 0;
		for(int n=1; n<=N-K; n++) {
			result += diff[n];
		}
		
		 bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}