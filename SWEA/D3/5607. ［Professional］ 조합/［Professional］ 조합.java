import java.io.*;
import java.util.*;

class Solution {
	
	static final int MOD = 1234567891;
	static long[] factorial = new long[1000001]; // 미리 계산해둘 팩토리얼 배열
	 
	static long pow(long a, long b) { // 분할정복, 페르마의 소정리 사용하여 거듭제곱(a^b) 구현
		if(b==0) return 1;
		
		long half = pow(a, b/2);
		if(b%2 == 0) return (half * half) % MOD;
		else return ((half * half) % MOD * a) % MOD; // 홀수일 때는 a를 추가적으로 한 번 더 곱해주어야 함
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 팩토리얼 배열 계산
		factorial[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
        	factorial[i] = (factorial[i-1] * i) % MOD;
        }
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			// 모듈러 연산에서의 나눗셈 => 역원을 곱하는 것으로만 정의됨
			// 역원 : a * a^-1 = 1
			// mod m에서의 역원 : ( b * N ) % m = 1일 때의 N 값
			// 페르마의 소정리 : p가 소수일 때, a^(p-1) = 1 (mod p)
						// 즉, a^(p-)을 p로 나누면 나머지가 항상 1
			
			long numerator = factorial[N];
			long denomiator = (factorial[R] * factorial[N-R]) % MOD;
			// 페르마의 소정리를 통해 나머지가 1로 나온 값의 역원을 또 구해야 하므로 MOD-2
			long inverseDenomiator = pow(denomiator, MOD-2);
			
			long result = (numerator * inverseDenomiator) % MOD;
			bw.write("#" + tc  + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}