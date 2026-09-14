import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        // 1. hashmap에 넣는다
            // key==값, value==index
        // 2. 하나씩 조회하면서 target - nums[i]가 key에 있는지 확인
        // 3. 있으면 즉시 반환

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            Integer j = map.get(target - nums[i]);

            if(j != null
            && j != i) {
                ans.add(i);
                ans.add(map.get(target - nums[i]));
                break;
            }
        }

        return ans.stream()
        .mapToInt(Integer::intValue)
        .toArray();
    }
}