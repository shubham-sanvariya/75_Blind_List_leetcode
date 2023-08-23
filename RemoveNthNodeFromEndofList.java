public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode3 temp = new ListNode3(1);
        temp.insertFirst(2).insertFirst(3).insertFirst(4).insertFirst(5);

        ListNode3 list = new ListNode3(2);
        list.insertFirst(3).insertFirst(4);

//        System.out.println(temp.next.val);
        removeNthFromEnd(temp,2);
//        while (temp != null) {
//            System.out.println(temp.val);
//            temp = temp.next;
//        }
    }

    public static ListNode3 removeNthFromEnd(ListNode3 head, int n) {
        ListNode3 node = new ListNode3(0);
        node.next = head;

        ListNode3 slow = node;
        ListNode3 fast = node;

        for(int i = 1; i <= n + 1; i++){
            fast = fast.next;
        }

        while( fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        System.out.println(node.val);
        return node;
    }
}
