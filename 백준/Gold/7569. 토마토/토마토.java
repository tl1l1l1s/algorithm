import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static Queue<Tomato> queue;
    
    // 방향: 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static final int[] dm = {-1, 0, 1, 0, 0, 0}; // 세로(N) 방향
    static final int[] dn = {0, 1, 0, -1, 0, 0}; // 가로(M) 방향
    static final int[] dh = {0, 0, 0, 0, 1, -1}; // 높이(H) 방향
    
    static class Tomato {
        int h; // 높이 (H)
        int m; // 세로 (N)
        int n; // 가로 (M)
        
        Tomato(int h, int m, int n) {
            this.h = h;
            this.m = m;
            this.n = n;
        }
    }
    
    static int solution() {
        while(!queue.isEmpty()) {
            Tomato curr = queue.poll();
            
            for(int i=0; i<6; i++) {
                int currM = curr.m + dm[i]; // 세로(N)
                int currN = curr.n + dn[i]; // 가로(M)
                int currH = curr.h + dh[i]; // 높이(H)
                
                if(currM >= 0 && currM < N 
                   && currN >= 0 && currN < M 
                   && currH >= 0 && currH < H) {
                    
                    // 배열 접근 순서: [높이][세로][가로]
                    if(box[currH][currM][currN] == 0) {
                    	// 큐에 익게 된 토마토들을 쭉 넣고
                        queue.add(new Tomato(currH, currM, currN));
                        // curr의 값 + 1을 한 것으로 설정해둔다. == 답을 구하기 쉽도록
                        box[currH][currM][currN] = box[curr.h][curr.m][curr.n] + 1;
                    }
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        for(int z=0; z<H; z++) {
            for(int y=0; y<N; y++) {    
                for(int x=0; x<M; x++) {
                	// 만약 익지 않은 토마토가 있다면 -1 반환
                    if(box[z][y][x] == 0) return -1;
                    result = Math.max(result, box[z][y][x]);
                }
            }
        }
        
        return result == 1 ? 0 : result - 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이
        
        box = new int[H][N][M];
        queue = new LinkedList<>();
        
        for(int z=0; z<H; z++) {
            for(int y=0; y<N; y++) {
                st = new StringTokenizer(br.readLine());
                for(int x=0; x<M; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                    if(box[z][y][x] == 1) {
                    	// 큐에 익은 토마토를 넣고 시작한다
                        queue.add(new Tomato(z, y, x));
                    }
                }
            }
        }
        
        System.out.println(solution());
    }
}
