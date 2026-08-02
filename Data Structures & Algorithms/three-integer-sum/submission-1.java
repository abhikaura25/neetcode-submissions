class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        // Edge case handling
        if (nums == null || nums.length < 3) {
            return resultList;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {

            if (nums[i] > 0) { // if after sorting it is positive no point continuing the loop
                break;
            }

            if (i > 0 && nums[i] == nums[i-1]) { //skip duplicate
                continue;
            }

            int target_num =  -nums[i];

            int low = i+1;
            int high = nums.length-1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum== target_num) {
                    resultList.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                } else if (sum > target_num) {
                    high--;
                } else {
                    low++;
                }
            }
        }

        return resultList;
        
    } 
}


