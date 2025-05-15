import java.io.*;
import java.util.*;

class Solution {
	
	static Integer[] nums;
	static HashSet<Integer> result;
		// #개선점 : -> 정렬+중복 제거가 가능한 TreeSet 사용 
	
	static void solution(int lastIndex, int left, int sum) {
		if(left == 0) {
			result.add(sum);
			
			return;
		}
		
		for(int i=lastIndex+1; i<7; i++) {
			solution(i, left-1, sum+nums[i]);
		}
		
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());

			nums = new Integer[7];
			result = new HashSet<Integer>();
			for(int i=0; i<7; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			// 개수가 7개이므로 3중 for문 돌려도 시간 초과 X !
			solution(-1, 3, 0);
			
			Integer[] res = new Integer[result.size()];
			result.toArray(res);
			Arrays.sort(res, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			
			bw.write("#" + tc + " " + res[4] + "\n");

		}

		bw.flush();
		bw.close();
		br.close();

	}

}