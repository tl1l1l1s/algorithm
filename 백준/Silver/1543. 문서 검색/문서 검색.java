import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public void input() throws Exception {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine().toString();
		String search = br.readLine().toString();
		
		while(word.indexOf(search) != -1) {
			answer++;
			word = word.substring(word.indexOf(search)+search.length());	
		}
		
		System.out.print(answer);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().input();
	}
}