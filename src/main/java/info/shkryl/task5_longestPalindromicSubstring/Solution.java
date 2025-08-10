package info.shkryl.task5_longestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0; // начальный индекс самого длинного палиндрома
        int maxLength = 0; // его длина

        // Перебираем все возможные центры
        for (int center = 0; center < s.length(); center++) {
            // Проверяем палиндром с центром в одном символе (нечётная длина)
            int len1 = expandFromCenter(s, center, center);

            // Проверяем палиндром с центром между двумя символами (чётная длина)
            int len2 = expandFromCenter(s, center, center + 1);

            // Берём максимальную длину из двух
            int len = Math.max(len1, len2);

            // Если нашли палиндром длиннее — обновляем начало и длину
            if (len > maxLength) {
                maxLength = len;
                start = center - (len - 1) / 2;
            }
        }

        // Возвращаем подстроку от start длиной maxLength
        return s.substring(start, start + maxLength);
    }

    /**
     * Метод расширяется влево и вправо от центра,
     * пока символы совпадают.
     *
     * @param s строка
     * @param left левый индекс центра
     * @param right правый индекс центра
     * @return длина найденного палиндрома
     */
    private int expandFromCenter(String s, int left, int right) {
        // Пока мы в пределах строки и символы совпадают
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Длина палиндрома: (right - left - 1)
        // Например: left=-1, right=3 → длина = 3 - (-1) - 1 = 3
        return right - left - 1;
    }

    public static void main(String[] args) {

        String s = "babad";

        Solution solution = new Solution();
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }
}
