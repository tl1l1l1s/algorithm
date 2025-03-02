import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String dnaString = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int start = 0, end = 0, res = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while(start <= S-P) {
			end = start + P;
			
			if(start == 0) {
				for(char temp : dnaString.substring(start, end).toCharArray()) {
					map.put(temp, map.getOrDefault(temp, 0)+1);
				}
			} else {
				map.put(dnaString.charAt(start-1), map.get(dnaString.charAt(start-1))-1);
				char newEndChar = dnaString.charAt(end-1);
				map.put(newEndChar, map.getOrDefault(newEndChar, 0)+1);
			}
            
			if(A <= map.getOrDefault('A', 0)
				&& C <= map.getOrDefault('C', 0)
				&& G <= map.getOrDefault('G', 0)
				&& T <= map.getOrDefault('T', 0)) {
				res++;
			}
			start++;
		}
		
		System.out.println(res);
	}

}
