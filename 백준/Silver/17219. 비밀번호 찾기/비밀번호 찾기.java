import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// 비밀번호 만들기
		// 사이트 주소의 수 N, 비밀번호를 찾으려는 사이트 수 M
		// N개 줄만큼 사이트 주소, 비밀번호
			// 사이트 주소 : 알파벳, -, .
			// 비밀번호는 대문자
			// 둘 다 최대 20자
		// M개 줄만큼 비밀번호를 찾으려는 사이트 주소 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> data = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			data.put(st.nextToken(), st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			bw.write(data.get(br.readLine()) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
