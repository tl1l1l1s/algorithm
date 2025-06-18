import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long u = 1;
		long d = 1;
		for(int i=n; i>1; i--) {
			u *= i;
		}
		for(int i=n-k; i>1; i--) {
			d *= i;
		}
		for(int i=k; i>1; i--) {
			d *= i;
		}
		
		bw.write(u/d + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}