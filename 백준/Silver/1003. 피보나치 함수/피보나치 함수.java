import java.io.*;
import java.util.*;

public class Main {
	static Integer[][] memoization = new Integer[41][2];
	
	static Integer[] fibonacci(int n) {
		if(memoization[n][0] == null || memoization[n][1] == null) {
			memoization[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
			memoization[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
		}
		
		return memoization[n];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		memoization[0][0] = 1; memoization[0][1] = 0; 
		memoization[1][0] = 0; memoization[1][1] = 1;
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			bw.write(memoization[N][0] + " " + memoization[N][1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}