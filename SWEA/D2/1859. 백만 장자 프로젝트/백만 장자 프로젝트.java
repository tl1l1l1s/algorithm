import java.util.*;
import java.io.*;

class Solution
{
    	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] price = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			// 구매가가 판매가보다 작아야 함
			// 최대 하루에 한 개만 구매가 가능함
			// 판매는 여러 개 가능
			// 구매가도 이익에 포함 (-로)
			long max = Long.MIN_VALUE;
			int num = 0;
			long cost = 0;
			long result = 0;
			for(int i=N-1; i>=0; i--) {
				if(max < price[i]) {
					result += (max * num - cost);
					max = price[i];
					cost = 0;
					num = 0;
				} else {
					cost += price[i];
					num++;
				}
			}
			result += max*num - cost;
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}