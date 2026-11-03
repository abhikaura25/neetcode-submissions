class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;

        int maxWater = 0;

        while (start < end) {
            int height = Math.min(heights[start], heights[end]);
            int width = end - start;

            maxWater = Math.max(maxWater, height * width);

            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxWater;
    }
}

