public class MergekSortedLists {

    public static void main(String[] args) {
        ListNode4 n1 = new ListNode4(1);
        n1.insertFirst(3).insertFirst(5);

        ListNode4 n2 = new ListNode4(13);
        n2.insertFirst(18).insertFirst(25);

        ListNode4 n3 = new ListNode4(2);
        n3.insertFirst(4).insertFirst(8);

        ListNode4 n4 = new ListNode4(22);
        n4.insertFirst(27).insertFirst(30);

        ListNode4[] lists = new ListNode4[4];

        lists[0] = n1;
        lists[1] = n2;
        lists[2] = n3;
        lists[3] = n4;

        mergeKLists(lists);
    }

    public static ListNode4 mergeKLists(ListNode4[] lists) {
        if (lists == null || lists.length == 0) return null;
        System.out.println(lists.length);
        int interval = 1;

       while (interval < lists.length){
           for (int i = 0; i + interval< lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
           }
           interval *= 2;
       }

       ListNode4 node = lists[0];
       while (node != null){
           System.out.print(node.val + " -> ");
           node = node.next;
       }
       return lists[0];
    }

    public static ListNode4 mergeTwoLists(ListNode4 list1, ListNode4 list2) {
        ListNode4 mergeList = new ListNode4(0);

        ListNode4 returnlist = mergeList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val){
                returnlist.next = list1;
                list1 = list1.next;
            }
            else {
                returnlist.next = list2;
                list2 = list2.next;
            }
            returnlist = returnlist.next;
        }

        if (list1 == null){
            returnlist.next = list2;
        }else if (list2 == null){
            returnlist.next = list1;
        }
        return mergeList.next;
    }
}

class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4() {}
    ListNode4(int val) { this.val = val; }
    ListNode4(int val, ListNode4 next) { this.val = val; this.next = next; }

    public ListNode4 insertFirst(int val){
        ListNode4 node = new ListNode4(val);
        ListNode4 current = this;

        while (current.next != null){
            current = current.next;
        }
        current.next = node;

        return this;
    }
}


