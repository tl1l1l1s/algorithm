import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 네 자리 연도
		// 원 연도 == (앞 두 자리 + 뒤 두 자리)^2
		boolean ans = false;
		int X = Integer.parseInt(br.readLine());
		double a = Math.pow(((X / 100) + (X % 100)+1), 2);
		
		for(int x = X+1; x <= 9999; x++) {
			int temp = (x / 100) + (x % 100);
			
			if(Math.pow(temp, 2) == x) {
				bw.write(x + "\n");
				ans = true;
				break;
			}
		}
		
		if(!ans) {
			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}