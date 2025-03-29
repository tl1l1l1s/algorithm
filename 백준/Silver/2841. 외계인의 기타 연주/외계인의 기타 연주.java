import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i;
		
		// 줄 별로 관리해야하므로 줄 6개를 위한 스택 생성
		Stack<Integer>[] guitar = new Stack[7];
		for(i = 0; i<7; i++) {
			guitar[i] = new Stack<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int result = 0;
		
		for(i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int currentString = Integer.parseInt(st.nextToken());
			int currentFret = Integer.parseInt(st.nextToken());
			
			// peek을 했을 때 에러가 나는 것을 방지하기 위해 사이즈 먼저 체크 
			if(guitar[currentString].size() > 0) {
				
				// peek한 것이 currentFret보다 크거나 같은 경우 while문
				while(guitar[currentString].size() > 0 && guitar[currentString].peek() >= currentFret) {
					
					// 같다면 pop() 진행, 밑에서 무조건 add를 하기 때문에
						// 밑에서 무조건 result++를 하기 때문에 result--를 한 번 해줌 
					if(guitar[currentString].peek() == currentFret) {
						guitar[currentString].pop();
						result--;
						continue;
					}
						
					// 큰 경우 pop, result++;
					guitar[currentString].pop();
					result++;
				}
			}
			
			// 사이즈가 0이거나 peek한 것이 currentFret보다 작은 경우 현재 값 추가, result++;
			guitar[currentString].add(currentFret);
			result++;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}
