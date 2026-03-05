import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 특정 원소의 개수
			// (0, 1) -> 2
			// (0, 2+) -> 1
			// (0, 0) -> 1
			// (1, 2+) -> 0
			// (1, 1) -> 0
			// (2+, 2+) -> 0
		
		long[] arr = new long[4];
		Arrays.fill(arr, 0);
		for(int i=0; i<N; i++) {
			long temp = Long.parseLong(st.nextToken());
			
			if(temp == 0) {
				arr[0] += 1;
			} else if(temp == 1) {
				arr[1] += 1;
			} else {
				arr[2] += 1;
			}
		}
		
		long result = 0;
		if(arr[0] > 1) {
			result += arr[0] * (arr[0]-1) / 2;
		}
		result += 2 * arr[0] * arr[1];
		result += arr[0] * arr[2];
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}