import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String code = br.readLine();
		int result = 0;
		for(int i = 0; i<code.toCharArray().length; i++) {
			if(code.charAt(i) >= 'A' && code.charAt(i) <= 'Z') {
				result += (i+result)%4 == 0 ? 0 : 4 - ((i+result) % 4);
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}