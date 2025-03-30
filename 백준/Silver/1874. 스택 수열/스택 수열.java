import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int i;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int start = 0;
		for(i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > start) {
				for(int j = start+1; j <= num; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				start = num;
			}
			
			if(stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else {
				bw.write("NO\n");
				bw.flush();
				bw.close();
				br.close();
				System.exit(0);
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
