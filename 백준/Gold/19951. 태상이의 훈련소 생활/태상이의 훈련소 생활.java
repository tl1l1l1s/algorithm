import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] ground = new int[N];
		// 누적 합 배열
		int[] adjustment = new int[N+1];
		for(int i=0; i<N; i++) {
			ground[i] = Integer.parseInt(st.nextToken());
		}
		
		int a, b, k;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			adjustment[a-1] += k;
			adjustment[b] += -k;
		}
		
		for(int i=0; i<N; i++) {
			adjustment[i+1] += adjustment[i];
			System.out.print(ground[i] + (adjustment[i])+ " ");
		}
		
		br.close();

	}

}
