import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int result = 0;
            
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[][] board = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int curr;
            for(int i=0; i<N; i++) {
                curr = 0;
                for(int j=0; j<N; j++) {
                    if(board[i][j] == 1) {
                    	curr+=1;
                        
                        if(curr == K) {
                        	
                            if(j+1 >= N) {
                                result++;
                            } else if(board[i][j+1] == 0) {
                            	result++;
                            }
                        }
                    } else {
                        curr = 0;
                    }
                }
            }
            
            for(int i=0; i<N; i++) {
                curr = 0;
                for(int j=0; j<N; j++) {
					if(board[j][i] == 1) {
                    	curr+=1;
                    	
                        if(curr == K) {
                            if(j+1 >= N) {
                                result++;
                            } else if(board[j+1][i] == 0) {
                            	result++;
                            }
                        }
                    } else {
                        curr = 0;
                    }
                }
            }
            
                bw.write("#" + test_case + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}