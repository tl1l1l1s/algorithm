import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	static int L;
	static int C;
	static String[] list;
	
	static void sol(String ans, int vowels, int last) throws IOException {
		if(ans.length() == L) {
			if(vowels >= 1 && L - vowels >= 2) {
				bw.write(ans + "\n");
			}
			return;
		}
		
		for(int i=last+1; i<list.length - (L-ans.length()-1); i++) {
			if(list[i].equals("a") ||
					list[i].equals("e") ||
					list[i].equals("i") ||
					list[i].equals("o") ||
					list[i].equals("u")) {		
				sol(ans+list[i], vowels+1, i);
			} else sol(ans+list[i], vowels, i);
		}
		
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		String sr = br.readLine();
		list = sr.split(" ");
		Arrays.sort(list); // 정렬
		
		//최소 한 개의 모음 a e i o u + 최소 두 개의 자음
		
		sol("", 0, -1);
		bw.flush();
		bw.close();
		br.close();

	}

}