import java.io.*;
import java.util.*;

public class Main {
	static int N;
	
	public static long count(long mid) {
		long result = 0;
		
		for(int i=1; i<=N; i++) {
			result += Math.min(mid / i, N);
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
	
		// B[k]의 값보다 작거나 같은 수가 K개 이상인 줄을 찾아야 함
		// i번째 행의 x보다 작은 수의 개수 : min(x // i, N)으로 줄의 개수를 찾아 안에 포함되는 값을 찾을 수 있음
		// 첫 번째 행부터 값을 모두 더해 K개가 포함되는 줄을 찾아서... 범위를 좁혀가며 구한다
		
		long low = 1;
		long high = (long) N*N;
		long mid;
		while(low < high) {
			mid = (low+high) / 2;
			
			long currentCount = count(mid);
			if(currentCount < K) {
				low = mid+1;
			} else {
				high = mid;
			}
		}
		
		bw.write(low + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}