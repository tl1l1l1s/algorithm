import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 미터계
		String meter = br.readLine();
		long result = 0;
		for(int i=0; i<meter.length(); i++) {
			int digit = meter.charAt(i) - '0';
			
			if(digit>4) {
				digit--;
			}

			result = result * 9 + digit;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}