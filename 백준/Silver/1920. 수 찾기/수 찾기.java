import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int nums[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int find[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);

		for(int i=0; i<M; i++) {
			if(BinarySearch(nums, find[i], 0, N-1)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}
	
	public static boolean BinarySearch(int[] arr, int target, int start, int end) {
		if(start>end) return false;
		
		int mid = (start + end)/2;
		
		if(arr[mid] == target) return true;
		
		if(arr[mid] > target) {
			return BinarySearch(arr, target, start, mid-1);
		} else {
			return BinarySearch(arr, target, mid+1, end);
		}
	}
}