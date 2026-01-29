import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int y = 0, k = 0;
		for(int i=0; i<N; i++) {
			String univ = br.readLine();
			
			if(univ.equals("yonsei")) {
				y=i;
			} else if(univ.equals("korea")) {
				k=i;
			}
			
		}

		bw.write((y > k ? "Yonsei Lost..." : "Yonsei Won!")  + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}