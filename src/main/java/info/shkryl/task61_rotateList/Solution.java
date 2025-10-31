package info.shkryl.task61_rotateList;

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
    public ListNode rotateRight(ListNode head, int k) {
        // Базовые случаи
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Шаг 1: найдём длину списка и последний узел (хвост)
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Шаг 2: уменьшаем k по модулю длины
        k = k % n;
        if (k == 0) return head; // поворот ничего не меняет

        // Шаг 3: соединяем хвост с головой → делаем список циклическим
        tail.next = head;

        // Шаг 4: находим узел, который станет новым хвостом
        // Это узел на позиции (n - k - 1) от начала (0-индексация)
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        // Шаг 5: новая голова — следующий узел после нового хвоста
        ListNode newHead = newTail.next;

        // Шаг 6: разрываем цикл
        newTail.next = null;

        return newHead;
    }
}
