import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		// M초의 시간 후 K개 생성, N명의 손님
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			HashMap<Integer, Integer> customer = new HashMap<Integer, Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				customer.put(x, customer.getOrDefault(x, 0) + 1);
			}
			List<Integer> key = new ArrayList<>(customer.keySet());
			Collections.sort(key);
			
			boolean flag = true; // 답변 반환용
			int current = 0; // 현재 초
			int index = 0;
			int b = 0; // 현재 구워진 붕어빵의 개수
			outer: 
			while(index < key.size() && current <= (key.get(key.size()-1))) {
				if(current > 0 && current % M == 0) { // M을 나누어떨어지면 b에 구워진 붕어빵 개수 추가
					b += K;
				}
				
				if(current == key.get(index)) { // 현재 초가 손님이 온 시간과 동일하다 (sort 완료)
					b -= customer.get(key.get(index)); // b에서 해당 시간이 필요한 붕어빵의 개수를 뺀다
					
					if(b < 0) { // 0 이하인 경우 탈출, flag 변경
						flag = false;
						break outer;
					}
					index++; // 붕어빵 개수가 부족하지 않은 경우 다음 손님 ++;
				}
				current++; // 현재 시간 증가
			}
			bw.write("#" + tc + " " + (flag ? "Possible" : "Impossible") + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}