import java.io.*;
import java.util.*;

public class Main {
	
	static int[] bottles;
	static TreeSet<Integer> result; // 중복 없이 Set + 정렬하고 싶어서
	
	static void solution(int a, int b, int c, boolean[][][] visited) {
		if(a == 0) { // A가 0인 경우 C번째 보틀에 든 양을 기록
			result.add(c);
		}
		
		int tempF;
		int tempT;
		// A > B
		if(a > 0 && b < bottles[1]) {
			tempF = a; tempT = b;
			tempT += tempF;
			if(tempT > bottles[1]) {
				tempF = tempT - bottles[1];
				tempT = bottles[1];
			} else { // 최대용량보다 작거나 같은 경우 a = 0
				tempF = 0;
			}
			
			if(!visited[tempF][tempT][c]) {
				visited[tempF][tempT][c] = true;
				solution(tempF, tempT, c, visited);
				visited[tempF][tempT][c] = false;
			}
		}
		
		// A > C
		if(a > 0 && c < bottles[2]) {
			tempF = a; tempT = c;
			tempT += tempF;
			if(tempT > bottles[2]) {
				tempF = tempT - bottles[2];
				tempT = bottles[2];
			} else {
				tempF = 0;
			}
			
			if(!visited[tempF][b][tempT]) {
				visited[tempF][b][tempT] = true;
				solution(tempF, b, tempT, visited);
				visited[tempF][b][tempT] = false;
			}
		}
		
		// B > A
		if(b > 0 && a < bottles[0]) {
			tempF = b; tempT = a;
			tempT += tempF;
			if(tempT > bottles[0]) {
				tempF = tempT - bottles[0];
				tempT = bottles[0];
			} else {
				tempF = 0;
			}
			
			if(!visited[tempT][tempF][c]) {
				visited[tempT][tempF][c] = true;
				solution(tempT, tempF, c, visited);
				visited[tempT][tempF][c] = false;
			}
		}
		
		// B > C
		if(b > 0 && c < bottles[2]) {
			tempF = b; tempT = c;
			tempT += tempF;
			if(tempT > bottles[2]) {
				tempF = tempT - bottles[2];
				tempT = bottles[2];
			} else {
				tempF = 0;
			}
			
			if(!visited[a][tempF][tempT]) {
				visited[a][tempF][tempT] = true;
				solution(a, tempF, tempT, visited);
				visited[a][tempF][tempT] = false;
			}
		}
		
		// C > A
		if(c > 0 && a < bottles[0]) {
			tempF = c; tempT = a;
			tempT += tempF;
			if(tempT > bottles[0]) {
				tempF = tempT - bottles[0];
				tempT = bottles[0];
			} else {
				tempF = 0;
			}
			
			if(!visited[tempT][b][tempF]) {
				visited[tempT][b][tempF] = true;
				solution(tempT, b, tempF, visited);
				visited[tempT][b][tempF] = false;
			}
		}
		
		// C > B
		if(c > 0 && b < bottles[1]) {
			tempF = c; tempT = b;
			tempT += tempF;
			if(tempT > bottles[1]) {
				tempF = tempT - bottles[1];
				tempT = bottles[1];
			} else {
				tempF = 0;
			}
			
			if(!visited[a][tempT][tempF]) {
				visited[a][tempT][tempF] = true;
				solution(a, tempT, tempF, visited);
				visited[a][tempT][tempF] = false;
			}
		}
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		bottles = new int[3];
		for(int i=0; i<3; i++) {
			bottles[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new TreeSet<Integer>();
		boolean[][][] visited = new boolean[bottles[0]+1][bottles[1]+1][bottles[2]+1];

		solution(0, 0, bottles[2], visited);
		Iterator iter = result.iterator();
		while(iter.hasNext()) {
			bw.write(iter.next() + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}