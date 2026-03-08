package info.shkryl.task88_mergeSortedArray;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Три указателя:
        int i = m - 1;      // Последний элемент в "заполненной" части nums1
        int j = n - 1;      // Последний элемент в nums2
        int k = m + n - 1;  // Позиция, куда записываем результат (конец nums1)

        // Пока есть элементы в обоих массивах
        while (i >= 0 && j >= 0) {
            // Сравниваем текущие элементы с конца
            if (nums1[i] > nums2[j]) {
                // Элемент из nums1 больше — записываем его
                nums1[k] = nums1[i];
                i--;  // двигаем указатель nums1 влево
            } else {
                //Элемент из nums2 больше или равен — записываем его
                nums1[k] = nums2[j];
                j--;  // двигаем указатель nums2 влево
            }
            k--;  // двигаем позицию записи влево
        }

        //ВАЖНО: Если в nums2 остались элементы — копируем их
        // (Если в nums1 остались — они уже на своих местах!)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
