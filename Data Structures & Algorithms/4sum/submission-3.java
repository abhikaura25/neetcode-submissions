class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) { //skip duplicate
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) { //skip duplicate
                    continue;
                }

                long requiredSum = (long) target-nums[i]-nums[j];

                int low = j+1;
                int high = nums.length - 1;

                while (low < high) {
                    long currentSum = (long) nums[low] + nums[high];
                    if (currentSum == requiredSum) {
                        resultList.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low-1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high+1]) {
                            high--;
                        }
                    } else if ( currentSum < requiredSum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return resultList;
        
    }
}