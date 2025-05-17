import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Boolean[] prime = new Boolean[1000001];
		prime[0] = false; prime[1] = false;
		
		// 에라토스테네스의 체
		for(int i=2; i<prime.length; i++) {
			if(prime[i] == null) {
				prime[i] = true;
				
				for(int j=2; i*j<prime.length; j++) {
					prime[i*j] = false;
				}
			}
			
			else continue;
			
		}
		
		for(int i=2; i<prime.length; i++) {
			if(prime[i]) {
				bw.write(i + " ");
			} else continue;
		}

		bw.flush();
		bw.close();
		br.close();

	}

}