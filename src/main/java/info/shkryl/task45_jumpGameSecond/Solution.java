package info.shkryl.task45_jumpGameSecond;

public class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;   // Граница текущего прыжка
        int farthest = 0;     // Максимально достижимая позиция

        // Проходим до предпоследнего элемента!
        for (int i = 0; i < nums.length - 1; i++) {
            // Обновляем самую дальнюю позицию, до которой можно добраться
            farthest = Math.max(farthest, i + nums[i]);

            // Если достигли границы текущего прыжка — пора прыгать!
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Оптимизация: если уже можем достичь конца — выходим
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution solution = new Solution();
        int result = solution.jump(nums);
        System.out.println(result);
    }
}
