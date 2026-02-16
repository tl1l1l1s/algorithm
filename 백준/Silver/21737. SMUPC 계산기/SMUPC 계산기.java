import java.io.*;
import java.util.*;

public class Main {
	static String str;
	static int idx;
	
	static long getNumber() {
		
		long result = 0;
		
		while(idx < str.length() &&
				str.charAt(idx) - '0' >= 0 && str.charAt(idx) - '0' <= 9) {
			result = (result * 10) + (str.charAt(idx) - '0');
			idx+=1;
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer.parseInt(br.readLine());
		str = br.readLine();
		
		// S = -
		// M = *
		// U = /
		// P = +
		// C = 결괏값 반환
		
		// 수로 시작, 알파벳으로 끝남
		// 0~9 / SMUPC
		// C 없으면 NO OUTPUT
		idx = 0;
		long result = getNumber();
		boolean isC = false;
		
		while(idx < str.length()) {
			char cmd = str.charAt(idx);
			idx+=1;
			long b = getNumber();
			
			switch(cmd) {
			case 'S':
				result -= b;
				break;
			case 'M':
				result *= b;
				break;
			case 'U':
				if(b==0) {
					result = 0;
				} else if(result < 0) {
					result = ((result * -1) / b) * -1;
				} else {
					result /= b;	
				}
				break;
			case 'P':
				result += b;
				break;
			case 'C':
				isC = true;
				bw.write(result + " ");
				break;
			}
		}
		
		if(!isC) {
			bw.write("NO OUTPUT\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}