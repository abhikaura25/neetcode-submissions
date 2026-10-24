class Solution {
    public int[] twoSum(int[] nums, int target) {

        /*
        Edge case : what will happen if length of array is 0 or 1. Here it is given 2.
        */
        Map<Integer, Integer> seen = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (seen.containsKey(need)) {
                return new int[] {seen.get(need), i};

            } else {
                seen.put(nums[i],i);
            }
        }
        
        return new int[]{-1,-1};
    }
}
