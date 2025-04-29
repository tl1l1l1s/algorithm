import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	static int N;
	static int M;
	static int nums[];
	
	static void permutation(int[] picked, int toPick) throws IOException {
		if(toPick == 0) {
			for(int i=0; i<picked.length; i++) {
				bw.write(picked[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		int lastIndex = picked.length - toPick;
		for(int i=0; i<N; i++) {
			
			boolean isDuplicate = false;
			for(int j=0; j<lastIndex; j++) { // 중복 검출
				if(picked[j] == nums[i]) {
					isDuplicate = true;
				}
			}
			
			if(isDuplicate) continue;
			
			picked[lastIndex] = nums[i];
			permutation(picked, toPick-1); // 재귀를 통한 순열 구현
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램 
		// N개 자연수 중 M개를 고른 수열
		// 순열 = 순서 관계 X , 얘는 순열 구하는 문제!

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		permutation(new int[M], M);
		
		bw.flush();
		bw.close();
		br.close();

	}

}