class Solution {
    public int majorityElement(int[] nums) {
        // Limitation if specified majority element dont exist. We have to second iteration to validate
        int count = 1;
        int ans = nums[0];

        for (int i=1; i < nums.length ; i++) {
            if (nums[i]== ans) {
                count++;
            } else if (count == 0) {
                ans = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }
}