class Solution {
    public int solution(String s) {
        int answer = s.length();
        // 짧은 문자열로 압축하고 싶다
        // 1개 이상의 단위로 잘라 압축
        // 최소로 짧게 표현할 수 있을 때의 길이
    
        for(int zip = 1; zip<=s.length()/2; zip++) {        
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, zip);
            int count = 1;
            
            for(int i=zip; i<=s.length(); i+=zip) {
                String next;
                if(i+zip <= s.length()) {
                    next = s.substring(i, i+zip);
                } else {
                    next = s.substring(i); // i~끝까지 자른다
                }
                
                if(prev.equals(next)) {
                    count++;
                } else {
                    if(count > 1) { // count가 1보다 큰 경우
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = next;
                    count = 1;
                }
            }
            if(prev.length() > 0) {
                if(count > 1) sb.append(count); // 1보다 큰 경우 안 들어간 것이 남았다는 것, 아닌 경우 sb.append
                 sb.append(prev);
            }
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}