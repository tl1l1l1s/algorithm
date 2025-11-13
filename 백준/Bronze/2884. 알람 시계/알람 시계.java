import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int resultH = H;
		int resultM = M - 45;
		
		if(resultM < 0) {
			resultM += 60;
			resultH -= 1;
		}
		
		if(resultH < 0) {
			resultH += 24;
		}
		
		bw.write(resultH + " " + resultM + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}