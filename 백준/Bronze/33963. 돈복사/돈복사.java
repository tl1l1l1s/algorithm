import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 돈복사 버튼을 누르면 2배가 됨
		// 금액 자리 수가 바뀌면 돈 압수 전까지 최대한
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		// 자리 수 구하기 : 10으로 나눴을 때 몫이 0이 되면
		int digit = 1;
		while(N / (int)Math.pow(10, digit) != 0) {
			 digit++;
		}
		
		int curr = N;
		while(curr / (int)Math.pow(10, digit) == 0) {
			result++;
			curr *= 2;
		}
		
		bw.write((result==0 ? 0 : result-1) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}