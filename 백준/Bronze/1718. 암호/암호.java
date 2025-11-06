import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String plainText = br.readLine();
		String encryptionText = br.readLine();
		StringBuilder result = new StringBuilder();
		
		int i = 0;
		for(char x : plainText.toCharArray()) {
			if(i == encryptionText.length()) i = 0;
			
			if(x == ' ') {
				result.append(' ');
			} else {
				int curr = x - encryptionText.charAt(i);
				
				if(curr <= 0) {
					result.append((char)('z'+curr));
				} else {
					result.append((char)(curr+'a'-1));
				}
			}
			
			i++;
		}
		
		bw.write(result.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}