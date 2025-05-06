import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 늘 100이므로 받지 않고 버림
			int[][] table = new int[100][100];
			
			// 위 = N, 아래 = S
			// 1 = N
			// 2 = S
			
			// 1인 경우 아래로 => 아래에 2 X
			// 2인 경우 위로 => 위에 1 X
			
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for(int i=0; i<100; i++) {
				int currentN = 0;
				
				for(int j=0; j<100; j++) { // 위에서 아래로 내려가는 방식으로 조회
					
					if(table[j][i] == 1) { // 1이면 N, 내려가야되는데 아래에 2가 있는지 확인해야 
						// 조회하면서 쭉 2가 있는지 확인할 것이므로
						// 그냥 현재 currentN을 추가해둔다 => 2를 안 만나면 그냥 떨어진다
						currentN++;
					}
					
					if(table[j][i] == 2) { // 2면 S, 올라가야되는데 1이 위에 있다면 교착상태 발생
						if(currentN > 0) { // 위에 1이 있음 -> 몇 개든 간에 교착상태 발생, result++ , N 개수 초기화
							result++;
							currentN = 0;
						}
					}
				}
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}