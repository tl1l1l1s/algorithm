import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		String T = br.readLine();

		StringBuilder sb = new StringBuilder();
		sb.append(T);
		
		int length = T.length();
		while(length > S.length()) {
		
			if(sb.charAt(length-1) == 'B') {
				sb.deleteCharAt(length-1);
				sb.reverse();
			} else {
				sb.deleteCharAt(length-1);
			}
			
			length--;
		}
		
		if(sb.toString().equals(S)) {
			bw.write("1");
		} else bw.write("0");
		
		bw.flush();
		bw.close();
		br.close();

	}

}