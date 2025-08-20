import java.io.*;
import java.util.*;

public class Main {
	static int result;
	
	private static void sol(int r, int c, int size) {
		if(size == 1) { 
			return;
		}
		
		if(r < size/2 && c < size/2) {
			sol(r, c, size/2);
		} else if(r < size/2 && c >= size/2) {
			result += size * size / 4;
			sol(r, c - size/2, size/2);
		} else if(r >= size/2 && c < size/2) {
			result += (size * size / 4) * 2;
			sol(r - size/2, c, size/2);
		} else {
			result += (size * size / 4) * 3; 
			sol(r - size/2, c - size/2, size/2);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		result = 0;
		
		sol(R, C, (int) Math.pow(2, N));
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}