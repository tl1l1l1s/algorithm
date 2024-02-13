import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k, index = 0;

	public static void main(String[] args) throws Exception {
		String word;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		String[] wheel = new String[n];
		for(int i=0; i<n; i++) {
			wheel[i] = "";
		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			index = (index + Integer.parseInt(st.nextToken())) % n;
			word = st.nextToken();
			
			// 추가하는 알파벳이 없는 경우
			if(Arrays.asList(wheel).indexOf(word) == -1) {
				// 해당 인덱스가 비어있지 않은 경우
				if(!wheel[index].equals("")) {
					System.out.print("!");
					return;
				}
			}
			// 추가하는 알파벳이 있는 경우
			else {
				// 해당 인덱스의 알파벳과 넣고자 하는 알파벳이 동일하지 않은 경우
				if(!wheel[index].equals(word)) {
					System.out.print("!");
					return;
				}
			}
			wheel[index] = word;
		}
		
		for(int i=0; i<n; i++) {
			if(wheel[index].equals("")) {
				System.out.print("?");
			} else {
				System.out.print(wheel[index]);
			}
			index = (index - 1 + n) % n;
		}
		br.close();

	}

}
