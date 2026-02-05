import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N개의 과일 탕후루
		// 1~9까지의 번호
		// S1...SN까지
		
		int N = Integer.parseInt(br.readLine());
		int[] fruits = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			fruits[n] = Integer.parseInt(st.nextToken());
		}
		
		int[] fq = new int[10]; // 종류 카운팅 배열
		int distinct = 0; // 종류 개수
		
		int res = 0;
		int left = 0;
		// 투 포인터
		for(int right = 0; right < N; right++) {
			int x = fruits[right];
			
			if(fq[x] == 0) distinct++;
			fq[x]++;
			
			while(distinct > 2) {
				int y = fruits[left++];
				fq[y]--;
				if(fq[y] == 0) distinct--;
			}
			
			res = Math.max(res, right-left+1);
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}