import java.io.*;
import java.util.*;

public class Main {
	static int M;
	static int card[];
	
	static int sum(int curr, int toPick, int sum) {
		int result = 0;
		
		if(toPick == 0 && sum <= M) {
			return sum;
		}
		
		// 이미 sum이 M 초과 시 0 반환
		if(sum > M) {
			return 0;
		}
		
		for(int i=curr; i<card.length; i++) {
			result = Math.max(result, sum(i+1, toPick-1, sum + card[i]));
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(sum(0, 3, 0) + "");
		bw.flush();
		bw.close();
		br.close();

	}

}