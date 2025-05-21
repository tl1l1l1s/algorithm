import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] nums;
	static ArrayList<Integer> result;
	static boolean[] visited;
	
	static void solution(int n, int t) {
		if(!visited[nums[n]]) { // 방문하지 않은 경우 확인을 위해
			visited[nums[n]] = true;
			solution(nums[n], t);
			visited[nums[n]] = false;
		}
		
        // 방문한 경우 처음 시작점과 동일한지 확인하여 싸이클 파악
		if(nums[n] == t) result.add(t);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 세로 2, 가로 N
		// 첫째 줄에서 뽑은 숫자의 개수 = 아랫줄에서 뽑은 숫자랑 일치
		// 이러한 경우를 최대한 많이
		// 제한 1초
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		result = new ArrayList<Integer>();
		visited = new boolean[N+1];
		
        // dfs -> 싸이클이 생기는지 파악
		for(int i=1; i<=N; i++) {
			visited[i] = true;
			solution(i, i);
			visited[i] = false;
		}
		
		Collections.sort(result);
		bw.write(result.size() + "\n");
		for(int x : result) {
			bw.write(x + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}