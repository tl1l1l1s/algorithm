import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 선물 상자에는 선물의 개수
		// 1~M명 아이들
			// 1~M번까지 선물이 가장 많이 담겨있는 상자에서 원하는 만큼 선물을 가져감 - 중복 상관 X
			// 적은 개수의 선물 - 실망
		
		int N = Integer.parseInt(st.nextToken()); // 선물 상자의 수
		int M = Integer.parseInt(st.nextToken()); // 아이들 수
		
		PriorityQueue<Integer> presents = new PriorityQueue<>((a, b) -> {
			return Integer.compare(b, a);
		});
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			presents.add(Integer.parseInt(st.nextToken()));
		}
		int[] children = new int[M]; // 아이가 원하는 선물의 개수
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			children[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean flag = true;
		for(int i=0; i<M; i++) {
			Integer currentPresent = presents.poll();
			
			if(currentPresent < children[i]) {
				flag = false;
				break;
			}
			presents.add(currentPresent - children[i]);
		}
		
		bw.write((flag ? "1" : "0") + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}