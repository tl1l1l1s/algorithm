import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 행운 = 0
		// 행운 수치 변화 주문서 N, M장씩 분배
		// 적절한 순서로 소모하여 행운 수치 변화
		
		// N : +a
		// M : *b
		long result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			result += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int c = Integer.parseInt(st.nextToken());
			if(c>0) {
				result *= c;
			}
		}
		// *0 무조건 처음에 빼야 함
		// *1은 없는 거나 마찬가지
		// +a 먼저 진행 후 2 이상의 b 진행
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}