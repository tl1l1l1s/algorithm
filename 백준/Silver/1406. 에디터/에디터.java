import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		int idx = sb.length();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "L":
				if(idx - 1 >= 0) {
					idx--;
				}
				break;
				
			case "D":
				if(idx + 1 <= sb.length()) {
					idx++;
				}
				break;
				
			case "B":
				if(idx > 0) {
					sb.deleteCharAt(--idx);
				}
				break;
				
			case "P":
				sb.insert(idx, st.nextToken());
				idx++;
				break;
			}
		}
		
		System.out.println(sb.toString());

	}

}
