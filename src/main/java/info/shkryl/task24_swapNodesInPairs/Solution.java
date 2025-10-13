package info.shkryl.task24_swapNodesInPairs;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Фиктивный узел, чтобы упростить работу с головой
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            // Определяем пару узлов
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Меняем местами
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Двигаем prev к следующей паре
            prev = first;
        }

        return dummy.next;
    }
}
