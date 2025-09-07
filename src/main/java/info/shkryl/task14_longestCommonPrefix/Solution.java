package info.shkryl.task14_longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Шаг 1: Проверяем, не пустой ли массив
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Шаг 2: Берём первое слово как эталон
        String first = strs[0];

        // Будем строить префикс по буквам
        StringBuilder prefix = new StringBuilder();

        // Шаг 3: Перебираем каждую букву первого слова
        for (int i = 0; i < first.length(); i++) {
            char currentChar = first.charAt(i); // текущая буква

            // Проверяем, что все остальные строки имеют эту букву на позиции i
            for (int j = 1; j < strs.length; j++) {
                // Если строка слишком короткая или буква не совпадает
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return prefix.toString(); // возвращаем то, что уже есть
                }
            }

            // Если всё совпало — добавляем букву в префикс
            prefix.append(currentChar);
        }

        // Вернём найденный префикс
        return prefix.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input = {"flower","flow","flight"};
        String result = solution.longestCommonPrefix(input);
        System.out.println(result);
    }
}
