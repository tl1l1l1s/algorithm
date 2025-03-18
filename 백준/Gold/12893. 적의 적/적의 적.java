import java.util.*;
import java.io.*;

public class Main {
	
	static List<Integer>[] relationship;
	static int[] status;
	
	static boolean DFS(int idx, int num) {
		if(status[idx] != -1) {
			return status[idx] == num;
		}
		
		for(int next : relationship[idx]) {
			status[idx] = num;
			
			if(!DFS(next, 1-num)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        // 
		relationship = new List[N+1];
		for(int i=1; i<=N; i++) {
			relationship[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			relationship[a].add(b);
			relationship[b].add(a);
		}
		
		status = new int[N+1];
		Arrays.fill(status, -1);
		
		for(int i=1; i<=N; i++) {
			if(status[i] != -1) {
				continue;
			}
			
			if(!DFS(i, 0)) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(1);
		
	}

}
