import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] houses = new int[N];
		int min = 2, max = 2, mid;
		for(int i=0; i<N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
        max = houses[N-1] - houses[0] + 1;
		
		while(min < max) {
			mid = (min + max) / 2;
		
			if(count(houses, mid) < C) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
	}
	
	public static int count(int[] houses, int distance) {
		int res = 1;
		int installed = houses[0];
		
		for(int i = 1; i<houses.length; i++) {
			int temp = houses[i];
			
			if(temp - installed >= distance) {
				res++;
				installed = temp;
			}
		}
		
		return res;
	}

}
