class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // sort the array. TC O(nlogn)
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }

            if ( i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int low = i + 1;
            int high = nums.length - 1;
            int target = -nums[i];

            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return result;
    }
}
