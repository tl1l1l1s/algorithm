import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for(char x : str.toCharArray()) {
			stack.push(x);
			
			if(stack.size() >= 4) {
				String res = "";
				for(int j=0; j<4; j++) {
					res = stack.pop() + res;
				}
				
				if(res.equals("PPAP")) {
					stack.push('P');
				} else {
					for(char y : res.toCharArray()) {
						stack.push(y);
					}
				}
			}
		}
		
		
		if(stack.size() == 1 && stack.peek().equals('P')) {
			bw.write("PPAP");
		} else {
			bw.write("NP");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
