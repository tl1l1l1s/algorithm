import java.io.*;
import java.util.*;

class Solution {
	
	static int N;
	static int B;
	static int[] H;
	
	static int solution(int lastIndex, int sum) {
		int result = Integer.MAX_VALUE;
		if(sum >= B) {
			return sum;
		}
		
		if(lastIndex==N-1) {
			return result;
		}
		
		for(int i=lastIndex+1; i<N; i++) {
			result = Math.min(solution(i, sum+H[i]), result);
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 높이 B 선반
		// H... 점원들의 키
			// H를 조합해
		// B 이상인 경우 사용 가능, 이 중 B에 제일 가까운 수, 출력은 B-그 수
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			H = new int[N];
			for(int i=0; i<N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write("#" + tc + " " + (solution(-1, 0) - B) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}