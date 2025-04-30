package swea;

import java.io.*;
import java.util.*;

public class sw1945 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int left = sc.nextInt();
			int two = 0;
			int three = 0;
			int five = 0;
			int seven = 0;
			int eleven = 0;
		
			while(left % 2 == 0) {
				left = left/2;
				two++;
			}
		
			while(left % 3 == 0) {
				left = left/3;
				three++;
			}
		
			while(left % 5 == 0) {
				left = left/5;
				five++;
			}
		
			while(left % 7 == 0) {
				left = left/7;
				seven++;
			}
		
			while(left % 11 == 0) {
				left = left/11;
				eleven++;
			}

			bw.write("#" + test_case + " " + two + " " +three + " " +five + " " + seven + " " + eleven + "\n");
		}
		bw.flush();
		bw.close();

	}

}