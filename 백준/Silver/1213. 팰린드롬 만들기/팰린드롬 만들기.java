import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String name = br.readLine();
		int[] letters = new int[26];
		Arrays.fill(letters, 0);
		
        // letters array에 개수를 저장
		for(char letter : name.toCharArray()) {
			letters[letter - 65] = letters[letter - 65] + 1;
		}

		// array 내 개수가 홀수이면 홀수인 수가 2개 이상 있으면 안 됨 
		// array 내 개수가 짝수면 홀수가 있으면 안 됨 => 어차피 짝수일 때 홀수가 하나 있으면 하나 이상임!
		boolean unable = false;
		for(int cnt : letters) {
			if(cnt%2 != 0) {
				if (!unable) {
						unable = true;
				} else if(unable) {
						bw.write("I'm Sorry Hansoo" + "\n");
						bw.flush();
						bw.close();
						System.exit(0);
				}
			}
		}
		
		char x = 0;
		for(int i=0; i<26; i++) {
			if(letters[i] % 2 != 0) {
                // 홀수인 것의 값을 저장해두고 나중에 추가할 거임
				x = (char)(i + 'A');
			}
			for(int j=0; j<letters[i]/2; j++) {
				sb.append((char)(i + 'A'));
			}
		}
		
		String result = sb.toString();
		if(unable) {
			result = result + x;
		}
		result += sb.reverse().toString();
		bw.write(result);
		bw.flush();
		bw.close();
		br.close();
	}

}