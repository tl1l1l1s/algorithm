import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		// 1 = 엄지
		// 2 = 검지
		// 3 = 중지
		// 4 = 약지
		// 5 = 새끼손가락
		int result = n % 8;
		if(result > 5) {
			result = (10 - result) % 8;
		} else if(result == 0) {
			result = 2;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}