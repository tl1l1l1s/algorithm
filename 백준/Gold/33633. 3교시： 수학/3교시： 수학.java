import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Long> arr;

	static void sol(int idx, long result) {
		
		if(idx == 1) {
			arr.add(result);
			return;
		}
		
		if(result - 1 > 0 && (result - 1) % 3 == 0
				&& (result - 1) / 3 > 1
				&& (result - 1) / 3 % 2 == 1) {
			sol(idx-1, (result - 1) / 3);
		}
		sol(idx-1, result * 2);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		// AN = 1
		
		// Ax % 2 == 0 -> Ax / 2
		// Ax % 2 != 0 -> Ax*3 + 1
		// (x!=N) Ax != 1
		
		arr = new ArrayList<Long>();
		sol(N, 1);
		Collections.sort(arr);
		
		bw.write(arr.size() + "\n");
		for(long x: arr) {
			bw.write(x +  "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}