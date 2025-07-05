import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int result = 0;
		Deque<Character> stack;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			stack = new ArrayDeque<>();
			
			for(char curr: str.toCharArray()) {
				if(stack.isEmpty()) stack.push(curr);
				else {
					if(stack.peek() == curr) stack.pop();
					else stack.push(curr);
				}
			}
			
			if(stack.isEmpty()) result++;
			
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}