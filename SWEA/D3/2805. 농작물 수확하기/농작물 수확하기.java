import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					farm[i][j] = Integer.parseInt(line.substring(j, j+1));
				}
			}

			// 5*5 => 02  
					//11 12 13
					//20 21 22 23 24 -> 5/2=2
					//31 32 33 
					//42
				// 5/2 = 2
					// 1이면 2 - 1 = 1 1만큼 차이, 5-(1*2)= 3개 작성
						// => 1,2,3
			
			// 7*7 => 03
					//12 13 14
					//21 22 23 24 25
					//30 31 32 33 34 35 36
					//41 42 43 44 45
					//52 53 54
					//63
			// 7/2가 mid. base
			// 7/2랑 얼마나 떨어져있느냐에 따라 -2씩 적용
			
			int base = N/2;
			int result = 0;
			for(int i=0; i<N; i++) {
				int degree = (N-(Math.abs(base-i))*2)/2;
				for(int j = base - degree; j <= base + degree; j++) {
					result += farm[i][j];
				}
				// N - ((base - i)*2)
					// 5, 2, 1
					// 5-2 =3 ; 3개 작성
					// 2-3/2 = 1,2,3 => base - ((base-i)*2) ~ 더한 것까지
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}