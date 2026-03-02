import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String mbti = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for(char x: mbti.toCharArray()) {
			if(x =='E') {
				sb.append('I');
			} else if(x == 'I') {
				sb.append('E');
			} else if(x == 'N') {
				sb.append('S');
			} else if(x == 'S') {
				sb.append('N');
			} else if(x == 'T') {
				sb.append('F');
			} else if(x == 'F') {
				sb.append('T');
			} else if(x == 'P') {
				sb.append('J');
			} else if(x == 'J') {
				sb.append('P');
			}
		}
		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}