import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		char board[][] = new char[N+1][M+1];
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=1; j<=M; j++) {
				board[i][j] = str.charAt(j-1);
			}
		}
		
		int prefix[][] = new int[N+1][M+1];
		for(int i=0; i<T; i++) {
			for(int j=1; j<N+1; j++) {
				for(int k=1; k<M+1; k++) {
					prefix[j][k] = prefix[j-1][k] + prefix[j][k-1] - prefix[j-1][k-1] + (board[j][k] == '*' ? 1 : 0);
				}
			}
			
			for(int j=1; j<N+1; j++) {
				for(int k=1; k<M+1; k++) {
					int rowMin = Math.max(j-K, 1);
					int colMin = Math.max(k-K, 1);
					int rowMax = Math.min(j+K, N);
					int colMax = Math.min(k+K, M);
					
					int around = prefix[rowMax][colMax] - prefix[rowMax][colMin-1] - prefix[rowMin-1][colMax] + prefix[rowMin-1][colMin-1];
					
					if(board[j][k]=='*') {
						around = around - 1;
						if(around < a || around > b) {
							board[j][k]='.';
						} else {
							board[j][k]='*';
						}
					} else {
						if(a < around && around <= b) {
							board[j][k]='*';
						} else {
							board[j][k]='.';
						}
					}
				}
			}
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
}