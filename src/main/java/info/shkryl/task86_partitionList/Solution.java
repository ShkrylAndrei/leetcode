package info.shkryl.task86_partitionList;

/**
 * Определение узла связного списка
 */
class ListNode {
    int val;          // значение узла
    ListNode next;    // ссылка на следующий узел

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        // Создаём два "фиктивных" начала для двух списков
        // Dummy-узлы упрощают работу: не нужно проверять "первый ли это элемент"
        ListNode dummyLess = new ListNode(0);      // Голова списка "меньше"
        ListNode dummyGreaterOrEqual = new ListNode(0); // Голова списка "больше или равно"

        // Указатели, которые будут "расти" при добавлении элементов
        ListNode lessPtr = dummyLess;
        ListNode greaterPtr = dummyGreaterOrEqual;

        // Проходим по исходному списку
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                // Элемент меньше x — добавляем в первый список
                lessPtr.next = current;
                lessPtr = lessPtr.next;  // двигаем указатель "хвоста"
            } else {
                // Элемент >= x — добавляем во второй список
                greaterPtr.next = current;
                greaterPtr = greaterPtr.next;  // двигаем указатель "хвоста"
            }
            current = current.next;  // идём дальше по исходному списку
        }

        // Соединяем два списка: конец "меньше" → начало "больше или равно"
        lessPtr.next = dummyGreaterOrEqual.next;

        // ВАЖНО: обрываем ссылку в конце второго списка, чтобы не было цикла!
        greaterPtr.next = null;

        //Возвращаем начало результирующего списка (пропускаем dummy-узел)
        return dummyLess.next;
    }
}
