package info.shkryl.task83_removeDuplicatesFromSortedList;

/**
 * Определение узла связного списка
 */
class ListNode {
    int val;          // значение узла
    ListNode next;    // ссылка на следующий узл

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

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Если список пустой или из одного элемента — нечего удалять
        if (head == null || head.next == null) {
            return head;
        }

        // 🚶 Начинаем "прогулку" с головы списка
        ListNode current = head;

        // Идём по списку, пока есть следующий элемент
        while (current.next != null) {

            // 🔍 Сравниваем текущий элемент со следующим
            if (current.val == current.next.val) {
                // Дубликат! "Выкидываем" следующий узел из цепочки
                current.next = current.next.next;
                // Важно: не двигаем current, т.к. новый next тоже может быть дубликатом
            } else {
                // Разные значения — идём дальше
                current = current.next;
            }
        }

        // 🎉 Возвращаем голову очищенного списка
        return head;
    }
}
