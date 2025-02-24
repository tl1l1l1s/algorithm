import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		do {
			if(isPrime(N)) {
				if(isPalindrome(N)){
					System.out.println(N);
					break;
				}
			} 
			N++;
		} while(true);
		
	}

	private static Boolean isPrime(int n) {
		if(n == 0 || n == 1) return false;
        
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		} return true;
	}
	
	private static Boolean isPalindrome(int n) {
		int left = n;
		int right = 0;
		
		while(left > right) {
			right = right * 10 + left % 10;
			left /= 10;
		}
		
		return (left == right || left == right/10);
	}
}
