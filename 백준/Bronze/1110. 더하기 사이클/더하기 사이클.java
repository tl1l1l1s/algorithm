import java.io.*;
import java.util.*;

public class Main {
	
	static int getNum(int N) {
		int n = (N/10) + (N%10);
		
		return ((N%10)*10) + (n%10);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 더하기 사이클
		// 0 <= N <= 99
			// 처음 주어진 수가 10보다 작다면 각 자리 숫자를 더함
			// 주어진 수의 가장 오른쪽 자리 수 + 합의 가장 오른쪽 자리 수 
		int N = Integer.parseInt(br.readLine());
		int tN = N;
		int result = 1;
		
		while(N != (tN = getNum(tN))) {
			result++;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}