import java.util.*;
class Solution {
    public String solution(String[] arr) {
        return Arrays.toString(arr)
            .replaceAll(",\s", "")
            .substring(1, arr.length+1);
    }
}