import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			// 1000*999 = 999000, 완전 탐색 가능
			// Ai*Aj의 값을 전부 구한 뒤
			// 단조 증가하는 수인지 확인 (전 자리보다 다음 자리가 크면 됨)
			int result = -1;
			boolean flag;
			for(int i=0; i<nums.length; i++) {
				for(int j=i+1; j<nums.length; j++) {
					flag = true;
					int current = nums[i] * nums[j];
					
					char[] curr = Integer.toString(current).toCharArray();
					for(int k=0; k<curr.length-1; k++) {
						if(curr[k] > curr[k+1]) {
							flag = false;
							break;
						}
					}
					
					if(flag) result = Math.max(result, Integer.parseInt(new String(curr)));
				}
			}
			// 개선점 : prevDigit = 10, 10*10 해가며 자릿수 비교
			
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}