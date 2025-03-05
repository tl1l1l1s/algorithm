import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int i = 0;
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] res = new int[N+M];
		int a = 0, b = 0;
		i = 0;
		while(a < N && b < M) {
			if(A[a] <= B[b]) {
				res[i] = A[a];
				a++;
			} else {
				res[i] = B[b];
				b++;
			}
			i++;
		}
		
		
		while(a<N) {
			res[i] = A[a];
			a++; i++;
		}
		while(b<M) {
			res[i] = B[b];
			b++; i++;
		}
		
		
		for(int num : res) {
			bw.write(num + " ");
		}
		bw.flush();
		bw.close();
	}

}
