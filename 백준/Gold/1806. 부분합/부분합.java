import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, sum = 0;
		int maxCount = Integer.MAX_VALUE;
		while(start <= end && end<=N) {
			if(sum < S) {
				sum += arr[end++];
			} else {
				maxCount = Math.min(maxCount, end-start);
				sum -= arr[start++];
			}
		}
		System.out.println(maxCount == Integer.MAX_VALUE ? 0 : maxCount);
	}

}
