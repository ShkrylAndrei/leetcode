package info.shkryl.task42_trappingRainWater;

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Обрабатываем левую сторону
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Новая стена
                } else {
                    // Вода над текущей позицией
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // Обрабатываем правую сторону
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Новая стена
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        int result = solution.trap(input);
        System.out.println(result);
    }
}
