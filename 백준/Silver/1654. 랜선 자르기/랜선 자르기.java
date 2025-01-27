import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long[] lans = new long[K];
		long min = 1, max = 0, mid;
		
		for(int i=0; i<K; i++) {
			lans[i] = Long.parseLong(br.readLine());
			max = Math.max(max, lans[i]+1);
		}
		
		while(min < max) {
			mid = (min+max)/2;
			long res = 0;
			
			for(int i=0; i<K; i++) {
				res += (lans[i]/mid);
			}
			
			if(res < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}

}
