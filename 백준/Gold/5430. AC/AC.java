import java.util.*;
import java.io.*;

public class Main {
	
	static LinkedList<String> q;
	static String command;
	
	static String solution () {
		Boolean isReverse = false;
		
		for(char cmd : command.toCharArray()) {
			if(cmd == 'R') {
				isReverse = !isReverse; // cmd가 R(리버스)일 때
			} 
			
			else if(cmd == 'D') { // cmd가 D(삭제)일 때
				if(q.size() == 0) { // 배열이 비어있으면 error 반환
					return("error\n");
				} 
				
				else {
					if(!isReverse) {
						q.pollFirst();
					} else { // 뒤집힌 경우 뒤에서 제거
						q.pollLast();
					}
				}
			}
		}
		
		if(!isReverse) { // 뒤집혀있지 않은 경우 그대로 출력
			return q.toString().replace(" ", "") + "\n";
		}
		
		// 뒤집힌 경우 다른 큐를 사용하여 값들을 뒤집는다
		Queue<String> q2 = new LinkedList<>();
		
		while(!q.isEmpty()) {
			q2.add(q.pollLast());
		}
		return q2.toString().replace(" ", "") + "\n";
	}


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			q = new LinkedList<>();
			command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			String s = br.readLine();
			if(n>0) {
				for(String x : s.substring(1, s.length()-1).split(",")) {
					q.add(x);
				}
			}
			
			bw.append(solution());
		}			
			
		
		bw.flush();
		bw.close();
	}

}
