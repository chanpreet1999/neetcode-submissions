class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMid( head );
        ListNode reversedHalf = reverse( mid.next );
        mid.next = null;
        rearrange( head, reversedHalf ); 
    }

    ListNode findMid( ListNode head ) {
        ListNode slow = head, fast = head;
        while( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse( ListNode head ) {
        ListNode prev = null, cur = head;
        while( cur != null ) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }

        private void rearrange(ListNode l1, ListNode l2) {
              ListNode c1 =l1, c2  = l2;

              while (c1 != null && c2 != null) {
                        ListNode next1 = c1.next;
                        ListNode next2 = c2.next;

                        c1.next = c2;
                        if (next1 == null) break;

                        c2.next = next1;

                        c1 = next1;
                        c2 = next2;
                }
        }
}