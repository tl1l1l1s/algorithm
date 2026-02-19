import java.io.*;
import java.util.*;

public class Main {
	
	static long MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		// 슬라임 에너지 * 슬라 에너지 = 전기 에너지
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			pq.clear();
			
			if(N == 1) {
				bw.write("1\n");
			} else {
				for(int n=0; n<N; n++) {
					pq.add(Long.parseLong(st.nextToken()));
				}
				
				long res = 1;
				long temp = 1;
				while(pq.size() > 1) {
					// 2 3 8 10 14
					// 6 8 10 14 -> 6
					// 48 10 14 -> 48
					// 48 140 -> 140
					// 6720 -> 6720
					
					temp = pq.poll() * pq.poll();
					pq.add(temp);
					res = (res * (temp % MOD)) % MOD;
				}
				bw.write((res % MOD)+ "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}

}