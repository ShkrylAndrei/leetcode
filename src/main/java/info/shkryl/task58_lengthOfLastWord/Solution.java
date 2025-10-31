package info.shkryl.task58_lengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int length = 0;

        // Шаг 1: пропускаем завершающие пробелы
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        // Шаг 2: считаем длину последнего слова
        while (index >= 0 && s.charAt(index) != ' ') {
            length++;
            index--;
        }

        return length;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        Solution solution = new Solution();
        int result = solution.lengthOfLastWord(str);
        System.out.println(result);
    }
}
