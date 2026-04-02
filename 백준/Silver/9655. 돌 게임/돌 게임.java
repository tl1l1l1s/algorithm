import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int i = N/3; // 홀수 = CY, 짝수 = SK
		int n = N%3; // 남은 개수고 1씩 빼면 됨
		
		if(n % 2 == 0) {
			bw.write(i%2 == 0 ? "CY" : "SK");
		} else bw.write(i%2 == 0 ? "SK" : "CY");

		bw.flush();
		bw.close();
		br.close();

	}

}