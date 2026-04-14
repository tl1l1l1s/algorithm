import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] towers = new int[N+1];
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		
        Deque<int[]> stack = new ArrayDeque<>();

        for(int i=1; i<=N; i++) {
        	while(!stack.isEmpty() && stack.peek()[0] < towers[i]) {
        		stack.pop();
        	}
        	
        	arr[i] = stack.isEmpty() ? 0 : stack.peek()[1];
        	stack.push(new int[] {towers[i], i});
        }
		
		for(int i=1; i<=N; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}