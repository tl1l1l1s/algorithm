import java.io.*;
import java.util.*;

public class Main {

	static int countDigit(int num) {
		int result = 0;
		
		while(num / 10 > 0) {
			result++;
			num /= 10;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int curr;
		int digit;
		while((curr = Integer.parseInt(br.readLine())) != 0) {
			
			while((digit = countDigit(curr)) > 0) {
				int temp = 0;
				for(int c=0; c<=digit; c++) {
					temp += curr%10;
					curr /= 10;
					
				}
				curr = temp;
			}

			bw.write(curr + "\n");
			bw.flush();
		}
		bw.close();
		br.close();

	}

}