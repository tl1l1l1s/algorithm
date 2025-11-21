import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] sushi = new int[N];
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		// 임의의 위치부터 연속 K개 먹을 경우 
		// 쿠폰의 초밥이 없는 경우 + 1
		
		// 일렬로 K개 끊었을 때 종류가 제일 많은, 그리고 K가 없는 경우 가산점
		int result = 0;
		
		Map<Integer, Integer> set = new HashMap<>();
		for(int i=0; i<K; i++) {
			set.put(sushi[i], set.getOrDefault(sushi[i], 0) + 1);
		}
		result = Math.max(result, set.keySet().contains(C) ? set.size() : set.size() + 1);
		for(int i=1; i<N; i++) {
			int j = (i+K-1 >= N) ? (i+K-1)%(N) : i+K-1;
			
			set.replace(sushi[i-1], set.get(sushi[i-1]) - 1);
			if(set.get(sushi[i-1]) == 0) {
				set.remove(sushi[i-1]);
			}
			set.put(sushi[j], set.getOrDefault(sushi[j], 0) + 1);
			result = Math.max(result, (set.keySet().contains(C) ? set.size() : (set.size() + 1)));
		}
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}