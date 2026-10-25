class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return true;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (low + nums.length / 2 < nums.length) && (nums[low + nums.length / 2] == target);
    }
}
