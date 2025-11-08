import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 3의 배수 = Fizz
		// 5의 배수 = Buzz
		int result = 0;
		String[] eles = new String[3];
		for(int i=0; i<3; i++) {
			eles[i] = br.readLine();
		}
		
		for(int i=0; i<3; i++) {
			if(eles[i].equals("Fizz") ||
			eles[i].equals("Buzz") ||
			eles[i].equals("FizzBuzz")) {
				continue;
			} else {
				result = Integer.parseInt(eles[i]) + 3 - i;
				break;
			}
		}
		
		if(result % 15 == 0) {
			bw.write("FizzBuzz");
		} else if(result % 3 == 0) {
			bw.write("Fizz");
		} else if(result % 5 == 0) {
			bw.write("Buzz");
		} else {
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}