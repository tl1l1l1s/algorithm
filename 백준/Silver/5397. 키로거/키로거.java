import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		Stack<Character> left;
		Stack<Character> right;
		int i;
		
		for(i = 0; i<L; i++) {
			left = new Stack<>();
			right = new Stack<>();
			String input = br.readLine();
			
			for(char x : input.toCharArray()) {
				switch(x) {
				case '-' :
					if(left.size() > 0) {
						left.pop();
					}
					break;
				case '<': // 왼쪽으로 이동
					if(left.size() > 0) {
						right.add(left.pop());
					}
					break;
				case '>': // 오른쪽으로 이동
					if(right.size() > 0) {
						left.add(right.pop());
					}
					break;
				default: // 입력한 글자를 추가
					left.add(x);
				}
			}
			
			String leftRes = left.toString();
			bw.write(leftRes.substring(1, leftRes.length()-1).replace(", ", ""));
			while(!right.isEmpty()) {
				bw.write(right.pop());
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}