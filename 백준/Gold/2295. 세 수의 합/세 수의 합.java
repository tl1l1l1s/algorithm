import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		int[] sum = new int[N * (N+1) / 2];
		int sumI = 0;
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				sum[sumI++] = numbers[i] + numbers[j];
			}
		}
		Arrays.sort(sum);
		
		int max = -1;
		for(int i = 0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int target = numbers[i] - numbers[j];
				if(Arrays.binarySearch(sum, target) > -1) {
					max = Math.max(max, numbers[i]);
				}
			}
		}
		
		System.out.println(max);
	}

}
