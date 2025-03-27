import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int i;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(i = 0; i<N; i++) {
            // stack에서 peek해서 확인한 값이 현재 확인 중인 index의 값보다 작으면
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				// pop 후 해당 index의 array 값을 변경
                arr[stack.pop()] = arr[i];
			}
			
            // 이후 스택에 현재 값을 push 
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		for(int n : arr) {
			bw.write(n + " ");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}
