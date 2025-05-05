import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] buildings = new int[N];

			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			// 양쪽 거리가 2개 이상 확보 -> 조망권 ㅇㅇ
			// 한 번 확보되면 중간부터 확보 안 되는 일은 없음
			
			// i=2 부터 시작, N-2까지를 검증
			// -2 + 2가 자기보다 작은지? 작은 값 중 최댓값을 빼고 더한다
			// 자기보다 큰 값 있으면 ㄴㄴ
			int result = 0;
			for(int i=2; i<N-1; i++) {
				int temp = 255;
				
				for(int j=i-2; j<i+3; j++) {
					if(buildings[j] > buildings[i]) {
						temp = 0;
						break;
					}
					else if(j != i) {
						temp = Math.min(buildings[i] - buildings[j], temp);
					}
				}
				result += temp;
			}
		
			bw.write("#" + tc + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}