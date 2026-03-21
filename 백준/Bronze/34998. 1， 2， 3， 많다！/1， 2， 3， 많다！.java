import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<TC; tc++) {
			int cc = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " + ");

			int result = 0;
			
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
				
				if(token.equals("!")) {
					result += 10;
				} else {
					result += Integer.parseInt(token);
				}
			}

			bw.write((result > 9 ? "!" : result) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}