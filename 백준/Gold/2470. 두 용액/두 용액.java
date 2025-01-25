import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		int[] result = new int[2];
		int s = 0, e = N-1, min = Integer.MAX_VALUE;
		
		while(s<e) {
			int sum = num[s] + num[e];
			
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				result[0] = num[s];
				result[1] = num[e];
				
				if(sum == 0) break;
			}
			if(sum < 0) s++;
			else {
				e--;
			}
		}
		
		System.out.println(result[0] + " " + result[1]);
	}

}
