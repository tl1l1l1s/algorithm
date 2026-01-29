import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		// 피라미드 층수 N
		// 겉 면 눈의 합의 최댓값과 최솟값의 합
		
		// 주사위 양면의 합 7
		// 1층 : 개별 1
		// 2층 : 개별 3
		// 3층 : 개별 6
		// n(n+1)/2개 주사위
		
		int dc = (N * (N+1)) / 2;
		bw.write((dc * 35) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}