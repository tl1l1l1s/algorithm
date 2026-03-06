import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 참가자 수
		int M = Integer.parseInt(st.nextToken()); // 진행된 결투의 횟수
		long result = 0;
		int max = 0;
		
		int[] n = new int[N+1];
		Arrays.fill(n, 0);
		HashMap<Integer, Long> map = new HashMap<>();
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int current = Integer.parseInt(st.nextToken());
			n[current] += 1;
			max = Math.max(max, n[current]);
		}
		
		for(int i=1; i<=N; i++) {
			map.put(n[i], map.getOrDefault(n[i], (long) 0) + 1);
		}
		
		// map의 key 정렬, key 정렬했으니까 0부터 ... 
		// 0 겹치는 게 1개이다 -> 스킵
		// 2개이다 -> 1번 필요 && 그리고 1을 1회 늘림
		// 그리고 1 겹치는 게 3개이다 -> 2번 필요
		
		for(int i=0; i<=max; i++) {
			long c = map.getOrDefault(i, (long) 0);
			
			if(c < 2) {
				continue;
			}
			
			if(i == max) {
		        result += (c - 1) * c / 2;			
	        } else {
	        	map.put(i + 1, map.getOrDefault(i + 1, 0L) + (c - 1));
	        	result += c - 1;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}