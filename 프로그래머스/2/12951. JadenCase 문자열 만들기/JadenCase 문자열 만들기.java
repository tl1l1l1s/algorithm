class Solution {
    public String solution(String s) {
        // 단어의 첫 문자가 대문자면 그 외에는 소문자
        // 첫 문자 != 알파벳 , 나머지는 소문자 
        
        StringBuilder sb = new StringBuilder();
        
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++) {
            if(arr[i].length() < 1) {
                sb.append(" ");
            } else if('a' <= arr[i].charAt(0) && arr[i].charAt(0) <= 'z') {
                sb.append(arr[i].substring(0, 1).toUpperCase());
            } else {
                sb.append(arr[i].charAt(0));
            }
            
            if(arr[i].length() > 1) {
                sb.append((arr[i].substring(1, arr[i].length())).toLowerCase());
            }
            
            if(arr[i].length() >= 1 && i != arr.length-1) {
                sb.append(" ");
            }
        }

        while(s.length() - sb.length() != 0) {
                sb.append(" ");
        }
        return sb.toString();
    }
}