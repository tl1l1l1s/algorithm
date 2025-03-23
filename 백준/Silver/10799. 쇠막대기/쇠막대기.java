import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Character> queue = new LinkedList<>();
		String arrangement = br.readLine();
		int res = 0;
		
		queue.add('(');
		for(int i=1; i<arrangement.length(); i++) {
			if(arrangement.charAt(i) == '(') {
				queue.add('(');
			} else {
				queue.poll();
				
				// 레이저인 상황
				if(arrangement.charAt(i-1) == '(') {
					res += queue.size();
				} 
                // 레이저가 아닌 상황
                else { 
					res += 1;
				}
				
			}
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();

	}

}
