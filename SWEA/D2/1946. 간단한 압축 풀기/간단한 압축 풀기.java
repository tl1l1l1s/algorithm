import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				String alphabet = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				
				for(int k=1; k<=count; k++) {
					sb.append(alphabet);
				}
			}

			bw.write("#" + tc + "\n");
			int k = 1;
			int base = 0;
			while(k<sb.length()) {
				if(k%10 == 0) { // 10이 될 때마다 다음으로 넘겨야되니까
					bw.write(sb.substring(base, k) + "\n");
					base+=10;
				}
				k++;
			}

			// 이후 남은 양 처리
			bw.write(sb.substring(base, sb.length()) + "\n");
			sb.delete(0, sb.length());
		}
		bw.flush();
		bw.close();
		br.close();

    }
}