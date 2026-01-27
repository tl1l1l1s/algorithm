import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] weighs = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			weighs[i] = Integer.parseInt(st.nextToken());
		}
		
		// 무게 x가 측정 가능 = 추의 일부 합이 x가 된다
			// { 0 .. x } U { wx+0 .. wx+x }
		Arrays.sort(weighs);
		
		int result = 1;
		for(int x: weighs) {
			if(result <= x - 1) {
				break;
			}
			result += x;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}