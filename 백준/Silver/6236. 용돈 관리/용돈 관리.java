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
		int[] money = new int[N];
		for(int i=0; i<N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		int min = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			max += money[i];
			min = Math.max(min, money[i]);
		}
		
		int mid, count, sum;
		while(min<=max) {
			mid = (min+max) / 2;
			
			count = 1;
			sum = 0;
			
			for(int currentMoney : money) {
				sum += currentMoney;
				
				if(sum > mid) {
					count++;
					sum = currentMoney;
				}
			}
			
			if(count > M) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		System.out.println(min);
		
	}

}
