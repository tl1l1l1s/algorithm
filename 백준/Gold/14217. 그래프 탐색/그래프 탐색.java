import java.util.*;
import java.io.*;

public class Main {
	
	static class City {
		int v, w;
		
		public City(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int q = Integer.parseInt(br.readLine());
		for(int k=0; k<q; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				graph[i].add(j);
				graph[j].add(i);
			} else {
				graph[i].remove(Integer.valueOf(j));
				graph[j].remove(Integer.valueOf(i));
			}
		
			boolean[] visited = new boolean[n+1];
			int[] city = new int[n+1];
			Arrays.fill(city, -1);
			
			Queue<City> qc = new LinkedList<>();
			qc.offer(new City(1, 0));
			visited[1] = true;
			city[1] = 0;
			
			while(!qc.isEmpty()) {
				City cur = qc.poll();
				int v = cur.v;
				int w = cur.w;
				
				for(int u : graph[v]) {
					if(!visited[u]) {
						qc.offer(new City(u, w+1));
						city[u] = w+1;
						visited[u] = true;
					}
				}
			}
			for(int x=1; x<=n; x++) {
				bw.write(String.valueOf(city[x]) + " ");
			}
			bw.write("\n");
		}
		
		
		
		bw.flush();
		bw.close();
	}

}
