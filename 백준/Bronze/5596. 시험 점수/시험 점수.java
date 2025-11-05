import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum1 = 0; int sum2 = 0;
		for(int i=0; i<4; i++) {
			sum1 += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			sum2 += Integer.parseInt(st.nextToken());
		}

		bw.write(Math.max(sum1, sum2) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}