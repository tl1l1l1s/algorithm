import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기화 기준 구하기
		int[] r = new int[(Math.min(N, M))/2];
		for(int ring = 0; ring < r.length; ring++) {
		    int height = N - (2*ring);
		    int width = M - (2*ring);
		    
		    r[ring] = 2*height + 2*width - 4;
		}
		
		for(int i=0; i<r.length; i++) {
			int border = i;
			
			for(int rR = 0; rR<R%r[i]; rR++) {
				// 첫 번째 값
				int temp = arr[border][border];

				// 왼쪽으로
				for(int k = border; k < M-1-border; k++) {
			    	arr[border][k] = arr[border][k+1];
				}	
				// 아래로
				for(int k = border; k < N-1-border; k++) {
			    	arr[k][M-1-border] = arr[k+1][M-1-border];
				}
				// 오른쪽으로
				for(int k = M-1-border; k > border; k--) {
			    	arr[N-1-border][k] = arr[N-1-border][k-1];
				}
				// 위로
				for(int k = N-1-border; k > border+1; k--) {
			    	arr[k][border] = arr[k-1][border];
				}
				// 마지막에 첫 번째 값 배치
				arr[border+1][border] = temp;
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}