import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	static int N;
	static int M;
	static int[] nums;
	
	static void repeatedCombination(int[] picked, int toPick) throws IOException {
		if(toPick == 0) {
			for(int i=0; i<M; i++) {
				bw.write(nums[picked[i]] + " ");
			}
			bw.write("\n");
			return;
		}
		
		int smallest;
		int lastIndex = M - toPick - 1;
		if(toPick == M) {
			smallest = 0;
		} else {
			smallest = picked[lastIndex];
		}
		for(int i=smallest; i<N; i++) {
			picked[lastIndex + 1] = i;
			repeatedCombination(picked, toPick-1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 중복조합
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		repeatedCombination(new int[M], M);

		bw.flush();
		bw.close();
		br.close();

	}

}