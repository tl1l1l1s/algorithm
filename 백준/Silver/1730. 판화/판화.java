import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char palette[][] = new char[n][n];
		int h = 0, w = 0;
		String movement = br.readLine();
		
		// palette[][] 초기화 진행 == 전부 .으로 변경
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				palette[i][j] = '.';
			}
		}
		
		for(int i=0; i<movement.length(); i++) {
			// if movement==U 위로 올라간다
			if(movement.charAt(i) == 'U' && h!=0) {
				if(palette[h][w] == '.') palette[h][w] = '|';
				else if(palette[h][w] == '-') palette[h][w] = '+';
			
				h--;
				if(palette[h][w] == '.') palette[h][w] = '|';
				if(palette[h][w] == '-') palette[h][w] = '+';
			}
			// if movement==D 아래로 내려간다
			else if(movement.charAt(i) == 'D' && h!=n-1) {
				if(palette[h][w] == '.') palette[h][w] = '|';
				else if(palette[h][w] == '-') palette[h][w] = '+';
				
				h++;
				if(palette[h][w] == '.') palette[h][w] = '|';
				if(palette[h][w] == '-') palette[h][w] = '+';
			}
			// if movement==L 왼쪽으로 간다
			else if(movement.charAt(i) == 'L' && w!=0) {
				if(palette[h][w] == '.') palette[h][w] = '-';
				else if(palette[h][w] == '|') palette[h][w] = '+';
				
				w--;
				if(palette[h][w] == '.') palette[h][w] = '-';
				else if(palette[h][w] == '|') palette[h][w] = '+';
				
			}
			// if movement==R 오른쪽으로 간다
			else if(movement.charAt(i) == 'R' && w!=n-1) {
				if(palette[h][w] == '.') palette[h][w] = '-';
				else if(palette[h][w] == '|') palette[h][w] = '+';
					
				w++;
				if(palette[h][w] == '.') palette[h][w] = '-';
				else if(palette[h][w] == '|') palette[h][w] = '+';
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(palette[i]);
		}
		br.close();
	}

}
