package info.shkryl.task49_groupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Ключ — отсортированная строка, значение — список анаграмм
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Преобразуем строку в массив символов, сортируем и собираем обратно
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // Добавляем исходную строку в соответствующую группу
            anagramGroups.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        // Возвращаем все группы как список списков
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(input);
        System.out.println(result);
    }
}
