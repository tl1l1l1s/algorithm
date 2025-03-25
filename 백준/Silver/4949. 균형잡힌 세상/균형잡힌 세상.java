import java.util.*;
import java.io.*;

public class Main {
	
	static Stack<Character> stack;
	
	static String check(String sentence) {
		stack = new Stack<>();
		
		for(char letter : sentence.toCharArray()) {
			switch(letter) {
			case '(':
				stack.add('(');
				break;
			case '[':
				stack.add('[');
				break;
			case ')':
				if(stack.size()>0) {
					if(stack.peek().equals('(')) {
						stack.pop();
						break;
					}
				}
				return "no\n";
			case ']':
				if(stack.size()>0) {
					if(stack.peek().equals('[')) {
						stack.pop();
						break;
					}
				}
				return "no\n";
			case '.':
				if(stack.size() > 0) {
					return "no\n";
				} return "yes\n";
			}
		}
		return "yes\n";
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String sentence = br.readLine();
			
			if(sentence.equals(".")) {
				break;
			}
			
			else {
				bw.write(check(sentence));
			}
		}
		
		bw.flush();
		bw.close();
	}

}
