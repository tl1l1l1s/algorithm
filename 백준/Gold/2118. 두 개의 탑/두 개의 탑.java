import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int distances[] = new int[N];
		int prefixSum[] = new int[N];
		prefixSum[0] = 0;
		
		for(int i=0; i<N; i++) {
			distances[i] = Integer.parseInt(br.readLine());
			if(i == 0) {
				prefixSum[i] = distances[i];
			} else {
				prefixSum[i] = prefixSum[i-1] + distances[i];
			}
		}
		
		int start = 0, end = 1;
		int min = Integer.MAX_VALUE;
		int res = 0;
		while(start < N-1) {
			int route = prefixSum[end] - prefixSum[start];
			if(Math.abs(route-(prefixSum[N-1]-route)) < min) {
				min = Math.abs(route-(prefixSum[N-1]-route));
				res = Math.min(route, prefixSum[N-1]-route);
			}
			end++;
			if(end == N) {
				start++;
				end = start + 1;
			}
		}
		
		System.out.println(res);
		
				
	}

}
