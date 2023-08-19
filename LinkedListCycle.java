public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode2 head) {
        ListNode2 slowpointer = head;
        ListNode2 fastpointer = head;

        while (slowpointer != null && fastpointer != null && fastpointer.next != null){
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;

            if (slowpointer == fastpointer) return true;
        }
        return false;
    }
}

 class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) {
        val = x;
        next = null;
    }
}