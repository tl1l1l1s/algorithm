import java.io.*;
import java.util.*;

public class Main {
	
	static int recursiveFib(int N) {
		if(N == 1 || N == 2) {
			return 1;
		}
		return recursiveFib(N - 1) + recursiveFib(N - 2);
	}
	
	static int dpFib(int N) {
		int result = 1;
		for(int i=3; i < N; i++) {
			result++;
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		bw.write(recursiveFib(N) + " " + dpFib(N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}