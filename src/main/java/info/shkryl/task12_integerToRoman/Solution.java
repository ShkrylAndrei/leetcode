package info.shkryl.task12_integerToRoman;

public class Solution {
    public String intToRoman(int num) {
        // Шаг 1: Определяем все возможные значения и их римские представления
        // Важно: идём от большего к меньшему, включая "исключения" (4, 9, 40, 90...)
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] symbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        // Шаг 2: Обрабатываем каждое значение
        for (int i = 0; i < values.length; i++) {
            // Пока текущее число больше или равно values[i]
            while (num >= values[i]) {
                result.append(symbols[i]);  // добавляем римское обозначение
                num -= values[i];           // вычитаем значение
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.intToRoman(5);
        System.out.println(result);
    }
}
