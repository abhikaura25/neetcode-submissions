class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] <= height[right]) {

                if (height[left] > lMax) {
                    lMax = height[left];
                } else {
                    water += lMax -height[left];
                }
                left++;

            } else {

                if (height[right] > rMax) {
                    rMax = height[right];
                } else {
                    water += rMax - height[right];
                }

                right--;

            }
        }

        return water;       
    }
}
