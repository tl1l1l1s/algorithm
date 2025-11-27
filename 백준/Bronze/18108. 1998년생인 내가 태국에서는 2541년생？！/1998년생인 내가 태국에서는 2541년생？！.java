import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int year = Integer.parseInt(br.readLine());
		 bw.write((year - 543) + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}