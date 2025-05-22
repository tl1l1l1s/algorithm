class Solution {
    public String solution(String s) {
        String[] sarr = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<sarr.length; i++) {
            int x = Integer.parseInt(sarr[i]);
            
            max = Math.max(x, max);
            min = Math.min(x, min);
        }
        return min + " " + max;
    }
}