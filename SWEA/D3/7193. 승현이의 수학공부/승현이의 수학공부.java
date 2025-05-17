import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String X = st.nextToken();
			
			// N % N-1 = 늘 1
			// aₖ×Nᵏ + aₖ₋₁×Nᵏ⁻¹ + ... + a₁×N¹ + a₀×N⁰
			// 이 식에서 N-aₖ₋₁1으로 나누면
			// Nᵏ, Nᵏ⁻¹가 싹 다 1이 되니까
			// aₖ+aₖ₋₁+...+a₀ 한 것만 N-1로 나누면 됨
			int sum = 0;
			for(int i=0; i<X.length(); i++) {
				sum += X.charAt(i) - '0';
			}
			
			bw.write("#" + tc + " " + sum%(N-1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}