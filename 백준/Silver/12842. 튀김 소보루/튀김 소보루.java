import java.io.*;
import java.util.*;

public class Main {
	
	static class Person implements Comparable<Person> {
		int idx;
		long time;
		
		Person(int idx, long time) {
			this.idx = idx;
			this.time = time;
		}
		
		void addTime(long t) {
			this.time += t;
		}

		@Override
		public int compareTo(Person o) {
		    return this.time != o.time
		            ? Long.compare(this.time, o.time)
		            : Integer.compare(this.idx, o.idx);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 튀김소보루 1 <= n <= 100000
		// 001에 두고, 집어든 거 제외하고 나갔다 오니 s개
		// m명, 1~m 식사 속도 예측 가능
		// 번호가 작은 사람이 먼저 집으며 영선이 나가면 먹기 시작
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		
		int m = Integer.parseInt(br.readLine());
		int[] takesTime = new int[m+1];
		
		PriorityQueue<Person> pq = new PriorityQueue<Person>();
		for(int i=1; i<=m; i++) {
			takesTime[i] = Integer.parseInt(br.readLine());
			
			pq.add(new Person(i, 0));
		}
		
		int temp = n;
		Person f = pq.peek();
		
		if(n-s <= m) {
			for(int x=0; x<n-s; x++) {
				f = pq.poll();
			}
		} else {
			while(temp > s) {
				f = pq.poll();
				f.addTime(takesTime[f.idx]);
				pq.add(f);
				temp--;
			}	
		}
		
		
		bw.write(f.idx + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}
