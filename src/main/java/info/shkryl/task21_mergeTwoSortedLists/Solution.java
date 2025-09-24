package info.shkryl.task21_mergeTwoSortedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    /**
     * Итеративное слияние двух отсортированных списков.
     * Создаём фиктивный узел (dummy), чтобы упростить логику.
     * Используем указатель current для построения нового списка.
     *
     * @param list1 голова первого отсортированного списка
     * @param list2 голова второго отсортированного списка
     * @return голова объединённого отсортированного списка
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Создаём фиктивный узел — он упрощает обработку начала списка
        ListNode dummy = new ListNode(0);
        // Указатель current будет двигаться по новому списку
        ListNode current = dummy;

        // Пока оба списка не пусты
        while (list1 != null && list2 != null) {
            // Выбираем узел с меньшим значением
            if (list1.val <= list2.val) {
                current.next = list1;  // Прицепляем list1 к результату
                list1 = list1.next;    // Переходим к следующему узлу в list1
            } else {
                current.next = list2;  // Прицепляем list2 к результату
                list2 = list2.next;    // Переходим к следующему узлу в list2
            }
            // Двигаем current вперёд — к только что добавленному узлу
            current = current.next;
        }

        // Если один из списков закончился — добавляем остаток другого
        // (он уже отсортирован, так что можно просто прицепить)
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Возвращаем начало реального списка — dummy.next
        return dummy.next;
    }
}
