import java.util.*;
import java.io.*;

public class Main {
	
	static class Lecture implements Comparable<Lecture> {
		int id;
		int start;
		int end;
		
		public Lecture(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}

		// 시작 시간이 빠른 순서(+ 종료 시간이 빨리 끝나는)대로 정렬
		public int compareTo(Lecture o) {
			if(this.start == o.start) {
				return this.end-o.end;
			}
			return this.start-o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Lecture> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			list.add(new Lecture(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int max = 1;
		for(int i = 0; i<N; i++) {
			while(!pq.isEmpty() && pq.peek()<=list.get(i).start) {
				pq.poll();
			}
			pq.add(list.get(i).end);
			max = Math.max(max, pq.size());
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}
