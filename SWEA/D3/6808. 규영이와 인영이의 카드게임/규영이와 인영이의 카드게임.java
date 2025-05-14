import java.io.*;
import java.util.*;

class Solution {
	
	static final int total = 171; // 1~18 합
	static int win, lose;
	static int[] sequence;
	static boolean[] visited;
	
	static void solution(int sum, int round) {
		if(round > 9) { // 라운드 순회가 끝난 경우
			if(sum > total-sum) { // 현재 값이 더 큰 경우
				win++;
			} else if(sum < total-sum) { // 현재 값이 더 작은 경우
				lose++;
			}
			return;
		}
		
		// 라운드 순회가 아직 남은 경우
		// 현재 반대편 애가 내는 값 = sq[r]
		// 내가 낼 값 : visited true만 빼고 다 한 번씩 해봐야 함
		for(int i=1; i<19; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
            if(sequence[round] > i) { // 쟤가 낸 값이 i(unvisited)보다 크면
				solution(sum, round+1);
			} else {
				solution(sum+sequence[round]+i, round+1);
			}
			visited[i] = false;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 1~18까지의 수가 적힌 18장의 카드
		// 카드를 섞어 9장씩 배분, 9 라운드에 걸쳐 짆애
		// 높은 수 카드 = 합만큼 점수
		// 낮은 수 카드 = 0
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			win = 0;
			lose = 0;
			sequence = new int[10];
			visited = new boolean[19];
			for(int i=1; i<10; i++) {
				sequence[i] = Integer.parseInt(st.nextToken());
				visited[sequence[i]] = true; // true로 미리, 방문할 일이 없게끔
			}
			
			solution(0, 1);
			
			bw.write("#" + tc + " " + lose + " " + win + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}