public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        ListNode3 node1 = new ListNode3(1);
        node1.insertFirst(3).insertFirst(5);

        ListNode3 node2 = new ListNode3(2);
        node2.insertFirst(6).insertFirst(8).insertFirst(10);

        ListNode3 current = node1;
        ListNode3 current2 = node2;
//        while (current != null){
//            System.out.println(current.val);
//            current = current.next;
//        }
//        while (current2 != null){
//            System.out.println(current2.val);
//            current2 = current2.next;
//        }
        mergeTwoLists(node1,node2);

    }

        public static ListNode3 mergeTwoLists(ListNode3 list1, ListNode3 list2) {
        ListNode3 mergeList = new ListNode3(0);

        ListNode3 returnlist = mergeList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val){
                returnlist.next = list1;
                list1 = list1.next;
            }
            else {
                returnlist.next = list2;
                list2 = list2.next;
            }
            System.out.println(returnlist.val);
            returnlist = returnlist.next;
        }

        if (list1 == null){
            returnlist.next = list2;
        }else if (list2 == null){
            returnlist.next = list1;
        }
        // for printing the value of the combined list
//        while (returnlist.next != null) {
//            System.out.println(returnlist.val);
//            returnlist = returnlist.next;
//        }
            System.out.println(mergeList.next.val + " flkasjfjd ");
        return mergeList.next;
    }
}

 class ListNode3 {
     int val;
     ListNode3 next;
     ListNode3() {}
     ListNode3(int val) { this.val = val; }
     ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }

     public ListNode3 insertFirst(int val){
         ListNode3 node = new ListNode3(val);
         ListNode3 current = this;

         while (current.next != null){
             current = current.next;
         }
         current.next = node;

         return this;
     }
}
