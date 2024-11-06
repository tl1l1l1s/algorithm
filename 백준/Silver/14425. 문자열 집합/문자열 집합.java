import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] S = new String[N];
		for(int i=0; i<N; i++) {
			S[i] = br.readLine();
		}
		
		for(int i=0; i<M; i++) {
			String keyword = br.readLine();
			
			for(int j=0; j<N; j++) {
				if(S[j].equals(keyword)) {
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}
}