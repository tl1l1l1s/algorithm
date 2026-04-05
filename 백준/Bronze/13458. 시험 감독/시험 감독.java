import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long result = N;
		for(int i=0; i<N; i++) {
			if(A[i] - B > 0) {
				result += (A[i] - B) / C;
				if((A[i] - B) % C != 0) {
					result += 1;
				}
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}