import java.io.*;

public class Main {
	
	static long[][] initMatrix = {{1, 1} , {1, 0}};
	
	static long[][] pow(long n) {
		if(n == 1) {
			return initMatrix; // 1일 때 F2 반환
		}
		
		long[][] res = new long[2][2];
		long[][] tmp;
		tmp = pow(n/2); // 분할
		
		// 분할된 tmp를 2 제곱 -> 분할 & 정복 
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 2; k++) {
					res[i][j] += tmp[i][k] * tmp[k][j];
				}
				res[i][j] %= 1000000;
			}
		}
		
		// 홀수인 경우 추가로 res * initMatrix 
		if(n % 2 == 1) {
			long[][] t = new long[2][2];
			
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					for(int k = 0; k < 2; k++) {
						t[i][j] += res[i][k] * initMatrix[k][j];
					}
					t[i][j] %= 1000000;
				}
			}
			return t;
		} else {
			return res;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		if(n == 1) {
			bw.write("1");
		} else {
			long[][] res = pow(n-1); // pow(1)이 F2를 반환하므로 n-1 
			bw.write(String.valueOf(res[0][0]));
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}