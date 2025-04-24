import java.io.*;
import java.util.*;

public class Main {
	static int W, B;
	static int[] weight;
	static boolean[][] result; // [cnt]개 추 사용 시 [weight]g 측정 가능 여부
	
	static void solution(int cnt, int num) {
		if(result[cnt][num]) return; // 중복계산 방지
		result[cnt][num] = true;
		
		if(cnt >= W) return;
		
		solution(cnt+1, num + weight[cnt]); // 현재 추 + 새로운 추
		solution(cnt+1, num); // 현재 추 사용 X
		solution(cnt+1, Math.abs(num - weight[cnt])); // 현재 추 반대편에 + 새로운 추
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		W = Integer.parseInt(br.readLine());
		weight = new int[W];
		result = new boolean[W+1][15001];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(0, 0);
	
		B = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<B; i++) {
			int curr = Integer.parseInt(st.nextToken());
			
			if(curr > 15000) bw.write("N ");
			else {
				bw.write((result[W][curr]) ? "Y " : "N ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
