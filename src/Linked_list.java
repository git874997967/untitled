public class Linked_list {
    static ListNode head;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 例题1 Given a linked list and a value x, write a function
     * to reorder this list such that all nodes less than x come
     * before the nodes greater than or equal to x
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;

        while (head != null) {
            if (head.val < x) {
                head = head.next;
                prev = prev.next;
            } else {
                p2.next = head;
                prev.next = head.next;
                head = prev.next;
                p2 = p2.next;
            }
        }
        p2.next = null;
        prev.next = fakeHead2.next;
        return fakeHead1.next;

    }


    /**
     * 例题 2 Given a linked list, write a function to return
     * the middle point of that list. 给定一个链表，编写一个函数以
     * 返回该链表的中间点
     */
    void printMiddle() {
        ListNode slow = head;
        ListNode fast = head;
        if (head != null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            System.out.println("The middle element is" + slow.val);
        }
    }

    public static void push(int new_data) {
        ListNode node = new ListNode(new_data);
        node.next = head;
        head = node;
    }

    /**
     * 例题 3 Find the kth to last element of a singly linked
     * list. For example, if given a list 1->2->3->4, and k equals
     * to 2, the function should return element 2.
     *
     * @param k the distance value to the last
     */
    public static void klast(int k) {
        ListNode slow = head;
        ListNode fast = head;
        //move k steps in advance
        if (head != null) {
            while (k > 0) {
                fast = fast.next;
                k--;
            }
            while (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            System.out.println(" the k distance to end is " + slow.val);
        }
    }

    /**
     * 例题 4 Given a linked list that may contain a circle,
     * write a function to return the node at the beginning of that
     * circle. Return NULL if such list doesn’t contain a circle.
     * <p>
     * 寻找摸个特定位置  用双指针技巧
     * and this only works in the circle linked list
     */
    public boolean detectCircle() {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)

                return true;
        }
        return false;
    }

    /**
     * 例题 5 Given a list, rotate the list to the right by k
     * places, where k is non-negative. e.g: 1->2->3->4->5, k = 2;
     * after rotation: 4->5->1->2->3
     *
     * @param args
     */
    public ListNode rotate(int args) {
        // the new head of the list is length-k
        // new tail until length-k-1
        if (head == null) return null;
        int len = 0;
        ListNode curr = head;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        /*
         * while(curr=head;curr.next!=null;curr=curr.next){
         *
         *       len++
         *
         * }/
         * */
        args = args % len;
        if (args == 0) return head; // which means did not rotate
        // update the curr
        //link the tail to the head
        curr.next = head;
        //update curr
        curr = head;
        // new tail is len-args-1
        for (int i = 0; i < len - args - 1; i++) {
            curr = curr.next;
        }
        // after the for curr is the new tail
        head = curr.next;
        ListNode newTail = curr;
        newTail.next = null;
        return head;
    }


    /**
     * 例题 6 Reverse the linked list and return the new head.
     * <p>
     * <p>
     * <p>
     * <p>
     * just change the realtionship between two nodes and change the tail to head
     * we use two temp to swap
     */

    public ListNode reverse() {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head = prev;
        return head;
    }

    /**
     * Given a linked list, swap every two adjacent nodes
     * and return its head
     *
     * @param
     */
    public ListNode swap() {
        ListNode first = null;
        ListNode second = null;
        first = head;
        while (first != null && first.next != null) {
            second = first.next;
            first.val = first.val + second.val;
            second.val = first.val - second.val;
            first.val = first.val - second.val;
            first = first.next.next;

        }
        return head;
    }

    /* public static Linked_list mergeList(Linked_list l1, Linked_list l2) {
         if (l1 == null) return l2;
         if (l2 == null) return l1;

         Linked_list newList = new Linked_list();
         ListNode l1_head = l1.head;
         ListNode l2_head = l2.head;
         while (l1_head != null && l2_head != null) {
             // l1 val is smaller
             if (l1_head.val < l2_head.val) {
               newList.push(l1_head.val);
                 l1_head = l1_head.next;
                 newList.head = newList.head.next;
             } else {
                 // l2 val is smaller
                 newList.push(l2_head.val);
                 l2_head = l2_head.next;
                 newList.head = newList.head.next;
             }

         }
         //consume one list empty  which exist will append directly
         if (l1_head != null) {
             newList.head.next = l1_head;
         } else {
             newList.head.next = l2_head;
         }
             newList.print();
         return newList;
     }*/

    /**
     * get algo from the youtube
     *
     * @return
     */
    public ListNode addOne() {
        if (head == null) return null;
        ListNode cur = head;
        int plus = 1;
        while (cur != null) {
            int val = cur.val + plus;
            if (val >= 10) {
                cur.val = val - 10;
                plus = 1;
            } else {
                cur.val = cur.val + plus;
                plus = 0;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * deleteMafterN
     *
     * @param m means after m bits
     * @param n means delete n bits
     */
    public ListNode deleteMafterN(int m, int n) {
        if (head == null) return null;
        ListNode cur = head;
        int length = m + n;
        while (cur != null) {
            length--;
            cur = cur.next;
        }
        if (length > 0) {
            System.out.println(" list not long enough");
            return null;
        } else {
            // begin to cut the list
            cur = head;
            while (m > 0) {
                cur = cur.next;
                m--;
            }
            ListNode newHead = cur;
            while (n > 0) {
                newHead = newHead.next;
                n--;
            }
            cur.next = newHead;

        }

        return head;
    }
    public static void main(String[] args) {
        Linked_list llist = new Linked_list();
      /*  Linked_list l1 = new Linked_list();
        Linked_list l2 = new Linked_list();*/
        for (int i = 80; i > 0; i = i - 10) {
            llist.push(i);
        }

        //llist.printMiddle();
        //llist.klast(3);
        //  System.out.println(llist.detectCircle());
        //llist.rotate(4);
        //llist.print();
        // llist.reverse();

        // llist.swap();
        //   llist.print();
        //l1.print();

        //   mergeList(l1, l2);

        // llist.print();
       /* ListNode newHead= new ListNode(1);
        newHead.next=new ListNode(9);
        newHead.next.next=new ListNode(9);
        newHead.next.next.next=new ListNode(9);*/
      /*  Linked_list llist2 = new Linked_list();
        llist2.push(1);
        llist2.push(9);
        llist2.push(9);
        llist2.push(9);
        llist2.addOne();
        llist2.print();*/
        llist.deleteMafterN(2, 3);
        llist.print();
    }

    // util function
    public void print() {
        ListNode tnode = head;
        while (tnode != null) {
            System.out.println("tnode->" + tnode.val);
            tnode = tnode.next;
        }
    }

}
