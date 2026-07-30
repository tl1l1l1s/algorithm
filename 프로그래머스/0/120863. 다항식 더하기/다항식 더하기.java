class Solution {
    public String solution(String polynomial) {
        long x = 0;
        long add = 0;
        
        String[] strarr = polynomial.split(" ");
        
        for(String str : strarr) {
            if(str.length() == 1 && str.charAt(str.length()-1) == 'x') {
                x += 1;
            } else if(str.charAt(str.length()-1) == 'x') {
                x += Integer.parseInt(str.substring(0, str.length()-1));
            } else if(!str.equals("+")) {
                add += Integer.parseInt(str);
            }
        }
        
        if(x == 0) {
            if(add == 0) return "";
            else {
                return "" + add;
            }
        } else { // x != 0
            if(add == 0) return (x == 1 ? "" : x) + "x";
            return (x == 1 ? "" : x) + "x + " + add;
        }
    }
}