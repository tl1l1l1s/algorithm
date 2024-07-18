import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] a = new int[N+1];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<N+1; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			a[i] = a[i] ^ a[i-1];
		}
		for(int i = 0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			answer ^= a[l-1] ^ a[r];
		}
				
		System.out.println(answer);
		br.close();
	}

}
