package info.shkryl.task9_PalindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        // Шаг 1: Отрицательные числа не могут быть палиндромами
        if (x < 0) {
            return false;
        }

        // Шаг 2: Числа, оканчивающиеся на 0, кроме самого 0, не палиндромы
        // Например: 10 → перевёрнутый вариант 01 = 1 ≠ 10
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        int reversedHalf = 0;

        // Шаг 3: Переворачиваем вторую половину числа
        // Пока x больше reversedHalf, продолжаем
        while (x > reversedHalf) {
            // Берём последнюю цифру x и добавляем в конец reversedHalf
            reversedHalf = reversedHalf * 10 + x % 10;
            // Убираем последнюю цифру из x
            x /= 10;
        }

        // Шаг 4: Сравниваем
        // Есть два случая:
        // 1. Число имеет чётное количество цифр: x == reversedHalf
        // 2. Нечётное: средняя цифра в середине, её можно игнорировать → x == reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(12321);
        System.out.println(result);
    }
}
