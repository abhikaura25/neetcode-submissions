class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j=i+1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long sum = (long) nums[i] + nums[j];
                int low = j + 1;
                int high = nums.length-1;
                long need = (long) target - sum;
                while (low < high) {
                    long sumAvailable = (long) nums[low] + nums[high];
                    if (need == sumAvailable) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                        while (low < high && nums[low]==nums[low-1]) {
                            low++;
                        }
                        while (low < high && nums[high]==nums[high+1]) {
                            high--;
                        }
                    } else if (need > sumAvailable) {
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