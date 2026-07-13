import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String cuttedString = s.substring(2, s.length() - 2);
        String[] groups = cuttedString.split("\\},\\{");
        
        int[][] intArr = new int[groups.length][];
        
        for (int i = 0; i < groups.length; i++) {
            String[] tokens = groups[i].split(",");
            intArr[i] = new int[tokens.length];

            for (int j = 0; j < tokens.length; j++) {
                intArr[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        
        Arrays.sort(
            intArr,
            Comparator.comparingInt((int[] arr) -> arr.length)
        );
        
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> ns = new HashSet();
        for(int i=0; i<intArr.length; i++) {
            for(int j=0; j<intArr[i].length; j++) {
                if(!ns.contains(intArr[i][j])) {
                    result.add(intArr[i][j]);
                    ns.add(intArr[i][j]);
                    break;
                }
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}