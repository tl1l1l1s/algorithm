import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[][] after;
	
	private static void lrInversion() {
		after = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {				
				after[N-i-1][j] = arr[i][j];
			}
		}
	}
	
	private static void udInversion() {
		after = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				after[i][M-j-1] = arr[i][j];
			}
		}
	}

	private static void rRotation() {
		after = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
                after[j][N-i-1] = arr[i][j];
			}
		}
		
		int temp = N;
		N = M;	
		M = temp;
	}
	
	private static void lRotation() {
		after = new int[M][N];
	    for(int i=0; i<N; i++) {
	        for(int j=0; j<M; j++) {
	            after[M-1-j][i] = arr[i][j];
	        }
	    }
		
		int temp = N;
		N = M;	
		M = temp;
	}
	
	private static void rPatitialRotation() {
		after = new int[N][M];
		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				after[i-N/2][j] = arr[i][j];
			}
		}
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				after[i][j+M/2] = arr[i][j];
			}
		}
		
		for(int i=N/2; i<N; i++) {
			for(int j=M/2; j<M; j++) {
				after[i][j-M/2] = arr[i][j];
			}
		}
		
		for(int i=0; i<N/2; i++) {
			for(int j=M/2; j<M; j++) {
				after[i+N/2][j] = arr[i][j];
			} 
		}
	}
	
	private static void lPatitialRotation() {
		after = new int[N][M];
		for(int i=0; i<N/2; i++) {
			for(int j=M/2; j<M; j++) {
				after[i][j-M/2] = arr[i][j];
			}
		}

		for(int i=N/2; i<N; i++) {
			for(int j=M/2; j<M; j++) {
				after[i-N/2][j] = arr[i][j];
			}
		}

		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				after[i][j+M/2] = arr[i][j];
			}
		}

		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				after[i+N/2][j] = arr[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			switch(cmd) {
			case 1:
				lrInversion();
				break;
			case 2:
				udInversion();
				break;
			case 3:
				rRotation();
				break;
			case 4:
				lRotation();
				break;
			case 5:
				rPatitialRotation();
				break;
			case 6:
				lPatitialRotation();
				break;
			}
			arr = after;
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