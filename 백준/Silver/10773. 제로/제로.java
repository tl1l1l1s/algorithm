import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long result = 0;
		int count = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for(int i=0; i<count; i++) {
			int curr = Integer.parseInt(br.readLine());
			
			if(curr == 0) {
				stack.pop();
			} else {
				stack.push(curr);
			}
		}
		
		while(!stack.isEmpty()) {
			result += stack.poll();
		}
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}