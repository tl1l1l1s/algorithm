import java.io.*;
import java.util.*;

public class Main {
	static int[][][] memo = new int[21][21][21];
	
	static int recursive(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a <= 20 && b <= 20 && c <= 20 && memo[a][b][c] != 0) {
			return memo[a][b][c];
		}
		
		if(a > 20 || b > 20 || c > 20) {
			return memo[20][20][20] = recursive(20, 20, 20);
		} else if(a<b && b<c) {
			return memo[a][b][c] = recursive(a, b, c-1) + recursive(a, b-1, c-1) - recursive(a, b-1, c);
		} else {
			return memo[a][b][c] =  recursive(a-1, b, c) + recursive(a-1, b-1, c) + recursive(a-1, b, c-1) - recursive(a-1, b-1, c-1);
		}		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 0보다 작거나 같아지면 1 반환
		// 20보다 크면 w(20, 20, 20)
		// a<b<c 이면 w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
		// 아니면 w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		while(a != -1 || b != -1 || c != -1) {
			for(int i=0; i<=20; i++) {
				for(int j=0; j<=20; j++) {
					for(int k=0; k<=20; k++) {
						memo[i][j][k] = 0;
					}
				}
			}
			
			bw.write("w(" + a + ", "  + b + ", " + c + ") = " + recursive(a, b, c) + "\n");
			
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		bw.flush();
		bw.close();
		br.close();

	}

}