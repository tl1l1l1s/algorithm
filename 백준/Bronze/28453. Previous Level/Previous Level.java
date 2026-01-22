import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 만렙 300
		// 구만렙 275
		// 구구만렙 250

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int n=0; n<N; n++) {
			int curr = Integer.parseInt(st.nextToken());
			int result;
			
			// 구간 1
			if(curr == 300) {
				result = 1;
			}
			// 구간 2
			else if(curr >= 275) {
				result = 2;
			}
			// 구간 3
			else if(curr >= 250) {
				result = 3;
			}
			// 구간 4
			else result = 4;
			
			bw.write(result + " ");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}