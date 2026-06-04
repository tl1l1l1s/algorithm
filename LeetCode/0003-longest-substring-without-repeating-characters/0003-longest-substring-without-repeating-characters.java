class Solution {
    public int lengthOfLongestSubstring(String s) {        
        int answer = 0;

        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap();

        while(end < s.length()) {
            if(map.containsKey(s.charAt(end))) {
                int nextStart = map.get(s.charAt(end));

                for(int i=start; i<=nextStart; i++) {
                    map.remove(s.charAt(i));
                }
                start = nextStart+1;
            }

            map.put(s.charAt(end), end);
            end++;
            answer = Math.max(answer, (end - start));
        }

        return answer;
    }
}