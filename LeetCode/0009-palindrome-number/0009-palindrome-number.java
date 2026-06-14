class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        char[] arr = Integer.toString(x).toCharArray();
        
        int start = 0;
        int end = arr.length - 1;
        while(end > start) {
            if(arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}