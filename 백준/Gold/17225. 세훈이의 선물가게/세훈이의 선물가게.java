import java.io.*;
import java.util.*;

public class Main {
	
	static class Order implements Comparable<Order> {
		int s;
		char c;
		
		public Order(int s, char c) {
			this.s = s;
			this.c = c;
		}
		
		@Override
		public int compareTo(Order o) {
			if(this.s == o.s) {
				return o.c - this.c;
			}
			return this.s - o.s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int b = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Order> pq = new PriorityQueue<>();
		int bMax = 0; 
		int rMax = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int m = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < m; j++) { // 주문 한 번씩
				if(c == 'B') {
					if(bMax >= t) { // 상민의 포장이 끝나는 시간보다 t가 빠를 경우 시작 시간이 bMax
						pq.add(new Order(bMax, 'b'));
						bMax += b;
					} else { // 상민의 포장이 끝나는 시간보다 t가 늦을 경우 pq에 시작시간과 t와 함께 등록
						pq.add(new Order(t, 'b'));
						bMax = t + b;
					}
				} else {
					if(rMax >= t) {
						pq.add(new Order(rMax, 'r'));
						rMax += r;
					} else {
						pq.add(new Order(t, 'r'));
						rMax = t + r;
					}
				}
			}
		}
		
		// 답을 구하기 위한 ArrayList, 순환하며 답을 도출
		ArrayList<Integer> blue = new ArrayList<>();
		ArrayList<Integer> red = new ArrayList<>();
		int idx = 1;
		while(!pq.isEmpty()) {
			Order order = pq.poll();
			
			if(order.c == 'b') {
				blue.add(idx);
			} else {
				red.add(idx);
			}
			idx++;
		}
		
		bw.write(blue.size() + "\n");
		for(int i=0; i<blue.size(); i++) {
			bw.write(blue.get(i) + " ");
		} bw.write("\n");
		bw.write(red.size() + "\n");
		for(int i=0; i<red.size(); i++) {
			bw.write(red.get(i) + " ");
		} bw.write("\n");

		bw.flush();
		bw.close();
		br.close();

	}

}