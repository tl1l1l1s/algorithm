import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int i = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		Queue<Integer> q = new LinkedList<>();
		for(i=0; i<N; i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			for(int j=0; j<K-1; j++) {
				q.add(q.poll());
			}
			result.add(q.poll() + 1);
			i++;
		}
		
		System.out.print("<");
		for(i=0; i<N-1; i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print(result.get(N-1));
		System.out.print(">");
	}

}
