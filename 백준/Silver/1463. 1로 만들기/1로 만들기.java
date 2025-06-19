import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N+1];
		memo[1] = 0;
		
		for(int i=2; i<=N; i++) {
			memo[i] = memo[i-1] + 1;
			
			if(i%3 == 0) {
				memo[i] = Math.min(memo[i], memo[i/3] + 1);
			}
			
			if(i%2 == 0) {
				memo[i] = Math.min(memo[i], memo[i/2] + 1);
			}
		}
	
		bw.write(memo[N] + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}