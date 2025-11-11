import java.io.*;
import java.util.*;

public class Solution {
	static int result;
	static int[] nums;
	static Set<String>[] visited;
	
	static String toStr(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<nums.length; i++) {
			sb.append(nums[i]);
		}
		return sb.toString();
	}
	
	static int toInteger(int[] nums) {
		int result = 0;
		int k = 1;
		for(int i=nums.length-1; i>=0; i--) {
			result += nums[i] * k;
			k *= 10;
		}
		return result;
	}

	static void findBiggestNum(int[] currentNum, int change) {
		if(visited[change].contains(toStr(currentNum))) return;
		visited[change].add(toStr(currentNum));
		if(change == 0) {
			result = Math.max(result, toInteger(currentNum));
			return;
		}
		
		for(int i=0; i<currentNum.length; i++) {
			for(int j=i+1; j<currentNum.length; j++) {
				if(i != j){
					int temp = currentNum[i];
					currentNum[i] =  currentNum[j];
					currentNum[j] = temp;
					
					findBiggestNum(currentNum, change-1);	
							
					temp = currentNum[i];
					currentNum[i] = currentNum[j];
					currentNum[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 퀴즈 우승 시 보너스 상금
		// 정해진 횟수만큼 서로 자리 위치 교환 가능
		// 제일 큰 값
		// 동일한 교환도 OK
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			String num = st.nextToken();
			nums = new int[num.length()];
			for(int i=0; i<nums.length; i++) {
				nums[i] = num.charAt(i) - '0';
			}
			int change = Integer.parseInt(st.nextToken());
			visited = new HashSet[change+1];
			for(int i=0; i<=change; i++) {
				visited[i] = new HashSet<>();
			}
			
			result = 0;
			findBiggestNum(nums, change);
			
			bw.write("#" + tc + " " + result + "\n");	
		}

		bw.flush();
		bw.close();
		br.close();
	}
}