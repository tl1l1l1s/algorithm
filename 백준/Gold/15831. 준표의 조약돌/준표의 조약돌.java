import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		String pebbles = br.readLine();
		
		int start = 0;
		int end = 0;
		int len = 0;
		int max = 0;
		int bCount = 0;
		int wCount = 0;
		
		while(end < N) {
			if(bCount > B) {
				if(pebbles.charAt(start) == 'B') {
					bCount--;
				} else {
					wCount--;
				}

				len--;
				start++;
			} else {
				if(pebbles.charAt(end) == 'B') {
					bCount++;
				} else {
					wCount++;
				}
				
				len++;
				end++;
			}
			
			if(bCount <= B && wCount >= W) {
				max = Math.max(len, max);
			}
		}
				
		System.out.print(max);
	}

}
