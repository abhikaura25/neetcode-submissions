class Solution {
    public boolean isMajorityElement(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target) {
            return true;
        }

        int low = 0;
        int high = nums.length-1;
        int requiredCount = nums.length/2;
        int count = 0;

        while (low <= high) {

            if (nums[low] == target) {
                count++;
            }
            if (nums[high] == target) {
                count++;
            }
            low++;
            high--;
           
        }

        if (count > requiredCount) {
            return true;
        }

        return false;
        
    }
}
