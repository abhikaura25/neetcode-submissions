class Solution {
    public int[] getConcatenation(int[] nums) {

        int[] resultArray = new int[nums.length*2];
        int length = nums.length;
        for (int i = 0 ; i< length; i++) {
            resultArray[i] = nums[i];
            resultArray[length+i] = nums[i];
        }
        return resultArray;
    }
}
