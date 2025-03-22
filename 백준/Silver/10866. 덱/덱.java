import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		LinkedList<Integer> deque = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			Integer x;
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push_front":
				x = Integer.parseInt(st.nextToken());
				deque.addFirst(x);
				break;
			case "push_back":
				x = Integer.parseInt(st.nextToken());
				deque.addLast(x);
				break;
			case "pop_front":
				x = deque.pollFirst();
				bw.append((x == null ? -1 : x) + "\n");
				break;
			case "pop_back":
				x = deque.pollLast();
				bw.append((x == null ? -1 : x) + "\n");
				break;
			case "size":
				bw.append(deque.size() + "\n");
				break;
			case "empty":
				bw.append((deque.isEmpty() ? 1 : 0) + "\n");
				break;
			case "front":
				x = deque.peekFirst();
				bw.append((x == null ? -1 : x) + "\n");
				break;
			case "back":
				x = deque.peekLast();
				bw.append((x == null ? -1 : x) + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();

	}

}
