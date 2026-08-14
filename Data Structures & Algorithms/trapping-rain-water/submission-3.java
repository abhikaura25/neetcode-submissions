class Solution {
    public int trap(int[] height) {

        int low = 0;
        int high = height.length-1;
        int lMax = 0;
        int rMax = 0;
        int water = 0;

        while (low < high) {

            if (height[low] <= height[high]) {

                if (height[low] > lMax) {
                    lMax = height[low];
                } else {
                    water += lMax - height[low];
                }
                low++;
            } else {
                if (height[high] > rMax) {
                    rMax = height[high];
                } else {
                    water += rMax - height[high];
                }
                high--;
            }
        }

        return water;
        
    }
}
