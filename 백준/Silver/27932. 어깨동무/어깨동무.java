import java.io.*;
import java.util.*;

public class Main {
	
	static int[] people;
	
	static int countK(int h) { // K명의 사람 수를 세는 함수
		int cnt = 0;
		boolean before = false;
		
		for(int i=0; i<people.length-1; i++) {
			boolean after = (Math.abs(people[i+1] - people[i]) > h);
			
			if(before || after) cnt++;
			before = after;
		}
		
		if(before) cnt++;
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 어깨동무 H보다 커지면 힘들다
		// 점수 차에 따라 H 값이 달라짐
		
		// 고려대 H점 차로 연세대 이김 -> H가 될 때까지 지치지 않음
		// 비기면 0
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); // k명 이하
		people = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		// 지친 사람이 k명 이하가 되기 위한 최소 점수 차이
		long L = 0, R = 1000000000L;
		
		while(L < R) {
			long M = (L+R) / 2;
			
			if(countK((int)M) <= k) {
				R = M;
			} else {
				L = M+1;
			}
		}

		bw.write(L + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}