import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		// 후.간.양 N마리씩
		// 치킨 선호도 A / B / C
		// 선호하는 종류의 치킨을 받을 수 있는 인원 수의 최댓값
		int N = Integer.parseInt(br.readLine());
		int[] chickens = new int[3];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) {
			chickens[i] = Integer.parseInt(st.nextToken());
			result += chickens[i] - N >= 0 ? N : chickens[i];
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}