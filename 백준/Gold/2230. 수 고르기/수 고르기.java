import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int res = Integer.MAX_VALUE;
		int start = 0;
		int end = 1;
		while(end<N) {
			int diff = arr[end] - arr[start];
			
			if(diff == M) {
				System.out.println(M);
				return;
			} else if(diff > M) {
				start++;
				res = Math.min(res, diff);
			} else {
				end++;
			}
			
			if(end == start) {	
				end++;
			}
		}
		System.out.println(res);
	}

}
