class Solution {
    static int result;

    // 고른 숫자 배열을 순회하며 XOR 연산하여 결과물 반환하는 함수 
    public static int xor(int[] picked) {
        int result = picked[0];
        for(int i=1; i<picked.length; i++) {   
            result ^= picked[i];
        }
        return result;
    }

    // 부분집합을 구하는 함수
    public static void subset(int[] nums, int curr, int left, int[] picked) {    	
        if(left == 0) {
            result += xor(picked);
            return;
        }
        
        for(int p=curr; p<nums.length; p++) {
        	if((nums.length - p) < left) continue;
        	
            picked[picked.length - left] = nums[p];
            subset(nums, p+1, left-1, picked);
        }

        return;
    }

    public int subsetXORSum(int[] nums) {
        result = 0;
        for(int i=1; i<=nums.length; i++) {
            subset(nums, 0, i, new int[i]);
        }
        return result;
    }
}