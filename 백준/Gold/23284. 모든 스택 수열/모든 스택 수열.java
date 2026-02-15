import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static Deque<Integer> stack;
	static BufferedWriter bw;
	
	static void dfs(int next, // 다음 수
			Deque<Integer> stack, // 스택 
			int[] out, // 출력용
			int len) // return 검증용 len 
					throws IOException {
	    if (len == n) {
	        for (int i = 0; i < n; i++) bw.write(out[i] + (i+1==n ? "\n" : " "));
	        return;
	    }

	    if (!stack.isEmpty()) { // stack에서 한 번 pop을 하는 경우
	        int x = stack.removeLast();
	        out[len] = x;
	        dfs(next, stack, out, len + 1);
	        stack.addLast(x);
	    }

	    if (next <= n) {
	    	stack.addLast(next);
	        dfs(next + 1, stack, out, len);
	        stack.removeLast();
	    }
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		dfs(1, new ArrayDeque<>(), new int[n], 0);
		bw.flush();
		bw.close();
		br.close();

	}

}