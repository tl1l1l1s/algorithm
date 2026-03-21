import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int result = 0;
		int left = 1000 - Integer.parseInt(br.readLine());
		
		result += left/500;
		left%=500;
		
		result += left/100;
		left%=100;
		
		result += left/50;
		left%=50;
		
		result += left/10;
		left%=10;
		
		result += left/5;
		left%=5;
		
		result += left/1;
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}