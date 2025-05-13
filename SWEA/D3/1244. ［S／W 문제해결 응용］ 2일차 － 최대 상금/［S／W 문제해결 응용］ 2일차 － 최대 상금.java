import java.io.*;
import java.util.*;

class Solution {
	
	static int max;
	static int swapCount;
	static Set<String> visited;
	
	static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}
	
	static void solution(char[] arr, int count) {
		
		if(count == 0) {
			max = Math.max(max, 
					Integer.parseInt(new String(arr)) // arr을 String으로 형 변환 후 parseInt();로 한 번에 변경
					);
			return;
		}
		
		String key = new String(arr) + count; // visited 확인, 비트마스킹처럼 현재 값 + 2회 변경한 경우가 있는지 확인
		if(visited.contains(key)) return;
		visited.add(key);
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				swap(arr, i, j);
				solution(arr, count-1);
				swap(arr, j, i);
			}
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
            max = 0;
			
			String str = st.nextToken();
			int C = Integer.parseInt(st.nextToken());
			visited = new HashSet<>();
			
			solution(str.toCharArray(), C);
			
			bw.write("#" + tc + " " + max + "\n");
		}


		bw.flush();
		bw.close();
		br.close();

	}

}