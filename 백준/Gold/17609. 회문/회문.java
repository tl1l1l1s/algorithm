import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[] strs = new String[T];
		for(int i = 0; i<T; i++) {
			strs[i] = br.readLine();
		}
		
		for(String str : strs) {
			if(isPalindrome(str)) {
				System.out.println(0);
			} else {
				int start = 0, end = str.length()-1;
				while(start<end) {
					if(str.charAt(start) == str.charAt(end)) {
						start++; end--;
					} else {
						if(isSimilarPalindrome(str, start, end)) {
							System.out.println(1);
						} else {
							System.out.println(2);
						}
						break;
					}
				}
			}
		}
	}
	
	private static Boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	
	private static Boolean isSimilarPalindrome(String str, int start, int end) {
		StringBuilder str1 = new StringBuilder(str);
		StringBuilder str2 = new StringBuilder(str);
		
		str1.deleteCharAt(start);
		str2.deleteCharAt(end);
		
		if(isPalindrome(str1.toString()) || isPalindrome(str2.toString())) {
			return true;
		}
		return false;
	}

}
