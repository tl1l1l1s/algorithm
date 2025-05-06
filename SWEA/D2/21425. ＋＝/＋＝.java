import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int result = 0;
			while(N >= A && N >= B) {
				// 작은 수에 큰 수를 늘 더해야 함
				if(A<B) {
					A+=B;
				} else {
					B+=A;
				}
				result++;
			}
			bw.write(result + "\n"); // while문에서 탈출할 때 이미 초과된 상태 = -1 해야 함
		}		
		bw.flush();
		bw.close();
		br.close();
	}
}