public class ReorderList {
    public static void main(String[] args) {
        ListNode3 list = new ListNode3(1);
        list.insertFirst(2).insertFirst(3).insertFirst(4).insertFirst(5);

        reorderList(list);
    }

    public static void reorderList(ListNode3 head) {
        if (head == null || head.next == null) return;
        // head of first half
        ListNode3 l1 = head;
        // head of second half
        ListNode3 slow = head;
        // tail of second half
        ListNode3 fast = head;
        // tail of first half
        ListNode3 prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode3 l2 = reverse(slow);

        merge(l1,l2);

        // 356 ms way
//        if (head == null || head.next == null || head.next.next == null) return;
//
//        ListNode3 last = head.next;
//        ListNode3 secondlast = head;
//
//        while (last.next != null) {
//            last = last.next;
//            secondlast = secondlast.next;
//        }
//        ListNode3 temp = head.next;
//        head.next = last;
//        last.next = temp;
//        secondlast.next = null;
//
//        reorderList(temp);
    }

    public static void merge(ListNode3 l1, ListNode3 l2) {
        while (l1 != null){
            ListNode3 l1_next = l1.next;
            ListNode3 l2_next = l2.next;

            l1.next = l2;
            if (l1_next == null) break;

            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }

    public static ListNode3 reverse(ListNode3 head) {
        ListNode3 prev = null;
        ListNode3 current = head;

        while (current != null){
            ListNode3 nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }


}
