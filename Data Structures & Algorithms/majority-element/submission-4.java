class Solution {
    public int majorityElement(int[] nums) {

        int answer = 0;
        int count = 0;

        for (int num: nums) {
            if (num == answer) {
                count++;
            } else if (count == 0) {
                answer = num;
                count++;
            } else {
                count--;
            }
        }

        return answer;
        
    }
}