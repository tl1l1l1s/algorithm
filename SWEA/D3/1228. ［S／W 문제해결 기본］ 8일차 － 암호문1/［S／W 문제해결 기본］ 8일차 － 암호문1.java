import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 암호문
		// 명령어 I x y s
			// x만큼 이후에 y개의 숫자 s들을 삽입
		for(int tc=1; tc<=10; tc++) {
			LinkedList<Integer> pwd = new LinkedList<Integer>();
			
			int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			
			st = new StringTokenizer(br.readLine()); // 원본 암호문
			for(int i=0; i<N; i++) {
				pwd.add(Integer.parseInt(st.nextToken()));
			}
			
			int CN = Integer.parseInt(br.readLine()); // 명령어의 개수
			
			st = new StringTokenizer(br.readLine()); // 명령어
			for(int i=0; i<CN; i++) {
				st.nextToken();
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				for(int j=0; j<Y; j++) {
					pwd.add(X+j, Integer.parseInt(st.nextToken()));
				}
			}
			
			bw.write("#" + tc + " ");
			for(int i=0; i<10; i++) {
				bw.write(pwd.get(i) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}