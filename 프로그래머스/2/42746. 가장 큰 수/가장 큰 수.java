import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) throws IOException {
        String[] nums = new String[numbers.length];
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
        
        if(nums[0].equals("0")) {
            return "0";
        }
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<nums.length; i++) {
			sb.append(nums[i]);
		}
		
        return sb.toString();
    }
}