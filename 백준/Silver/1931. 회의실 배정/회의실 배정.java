import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = 0;
		int lastEnd = 0;
		
		int N;
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] == b[1]) {
					return Integer.compare(a[0], b[0]);
				}
				return Integer.compare(a[1], b[1]);
			}
		});
		
		for(int i = 0; i<N; i++) {
			if(lastEnd <= arr[i][0]) {
				count++;
				lastEnd = arr[i][1];
			}
		}
		
		System.out.println(count);
		br.close();

	}

}
