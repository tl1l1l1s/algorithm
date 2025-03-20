import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 버퍼의 크기 N
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> buffer = new LinkedList<>();
		
		// -1이 나올 때까지 라우터가 처리해야 할 정보가 주어짐
			// 패킷의 번호, 0은 하나를 처리했음을 의미
		int curr = Integer.parseInt(br.readLine());
		do {
			if(curr == 0) {
				// 0인 경우 poll을 통해 제거 
				buffer.poll();
			} else {
				// buffer.size()가 N보다 큰 경우 무시 
				if(buffer.size() < N) {
					buffer.add(curr);
				}
			}
			curr = Integer.parseInt(br.readLine());
		} while(curr != -1);
		
		// 남아있는 패킷을 앞에서부터 순서대로 출력, 비어있는 경우 empty
		if(!buffer.isEmpty()) {
			for(int packet : buffer) {
				System.out.print(packet+ " ");
			}
		} else {
			System.out.print("empty");
		}

	}

}
