import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// M+1 할인 상품은 할인 중복 적용 X
		// M+1개 구매할 때 할인 방식 중 더 저렴한 것
		long N = Long.parseLong(st.nextToken()); // N% 할인
		long M = Long.parseLong(st.nextToken()); // M+1 제품
		long S = Long.parseLong(st.nextToken()); // 물건의 가격 
		
		// M+1개 구매, N% 할인 적용
		long NS = (S * (M+1)) * (100-N) / 100;
		long MS= S * M;
				

		bw.write(Math.min(NS, MS) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}