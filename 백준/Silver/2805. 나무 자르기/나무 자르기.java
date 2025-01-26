import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];

		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, trees[i]);
		}
		
		while(start < end) {
			int mid = (start + end) / 2;
			long sum = 0;
			
			for(int i=0; i<N; i++) {
				if(trees[i] - mid > 0) {
					sum += trees[i] - mid;
				}
			}
			
			if(sum < M) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(start - 1);
	}

}
