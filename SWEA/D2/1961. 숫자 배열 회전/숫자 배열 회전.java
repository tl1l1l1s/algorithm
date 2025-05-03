import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    
    static int[][] rotate(int[][] matrix) {
        int[][] result = new int[N][N];
        
        // 0,0 0,1 0,2
        // 2,0 1,0 0,0
        
        // 1,0 1,1 1,2
        // 2,1 1,1 0,1
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                result[j][i] = matrix[N-i-1][j];
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] rotate90 = rotate(matrix);
            int[][] rotate180 = rotate(rotate90);
            int[][] rotate270 = rotate(rotate180);
            
            bw.write("#" + test_case + "\n");
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    bw.write(rotate90[i][j] + "");
                }
                bw.write(" ");
                for(int j=0; j<N; j++) {
                    bw.write(rotate180[i][j] + "");
                }
                bw.write(" ");
                for(int j=0; j<N; j++) {
                    bw.write(rotate270[i][j] + "");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}