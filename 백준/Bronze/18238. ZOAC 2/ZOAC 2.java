import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 원판 -> A
		// 왼쪽/오른쪽 회전 가능, 한 칸 = 1의 시간
		String str = br.readLine();
		
		int curr = 0; // 'A' 65
		int idx = 0;
		int res = 0;
		while(idx < str.length()) {
			char c = str.charAt(idx);

			// n < 0인 경우 25 + n
			// n > 0인 경우 n - 24 혹은 n
			
			int diff = Math.abs(curr - (c - 'A'));
			res += Math.min(diff, 26 - diff);
			
			curr = c - 'A';
			idx++;
		}
		
		bw.write(res + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}