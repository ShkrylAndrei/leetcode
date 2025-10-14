package info.shkryl.task27_removeElement;

public class Solution {
    public int removeElement(int[] nums, int val) {
        // Указатель на позицию для следующего "хорошего" элемента
        int i = 0;

        // Проходим по всему массиву
        for (int j = 0; j < nums.length; j++) {
            // Если текущий элемент НЕ равен val — он нам подходит!
            if (nums[j] != val) {
                nums[i] = nums[j]; // Кладём его в "чистую" зону
                i++;               // Двигаем границу хороших элементов
            }
            // Если nums[j] == val — просто пропускаем (ничего не делаем)
        }

        // i — это количество элементов, не равных val
        return i;
    }
}
