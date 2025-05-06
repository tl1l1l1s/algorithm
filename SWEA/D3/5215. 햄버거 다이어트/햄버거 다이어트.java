import java.io.*;
import java.util.*;

class Solution {
	static int N;
	static int L;
	static int[][] ingredients;
	
	static int solution(int[] picked, int current, int sum) {
		int result = 0;
		int temp;
		
		if(sum > L) { // L을 초과하는 순간 끄트머리 한 자리를 빼고 전부 더해서 반환
			temp = 0;
			for(int i=0; i<current-1; i++) {
				temp += ingredients[picked[i]][0];
			}
			return temp;
		}

		int smallest = 0; // 중복 방지하려고 최소값, 이미 고른 값 중 마지막 값 확인
		if(current == 0) { // 처음 시작인 경우
			smallest = -1;
		} else {
			smallest = picked[current-1];
		}
		
		if(smallest == N-1) {
			temp = 0;
			for(int i=0; i<current; i++) {
				temp += ingredients[picked[i]][0];
			}
			return temp;
		}
		
		for(int i=smallest+1; i<N; i++) {
			picked[current] = i;
			result = Math.max(solution(picked, current+1, sum+ingredients[i][1]), result);
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 칼로리 이하의 조합 중 점수가 제일 높은 것
		// 같은 재료 여러 번 X

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingredients = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken()); // 점수
				ingredients[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}
						
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = 0;
			}
			bw.write("#" + tc + " " + solution(arr, 0, 0) +"\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}