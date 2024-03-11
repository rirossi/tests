package lists;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 */
public class AddLinkedList {


    public static void main(String[] argv) {
        ListNode one = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode two = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(mergeLists(one, two));
    }

    public int lengthOfLongestSubstring(String s) {
        int MAX = 1;
        for (int i = 0; i < s.length(); i++) {

            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    // reset and add new one.
                    set.clear();
                }
                set.add(s.charAt(j));
                MAX = Math.max(MAX, set.size());
            }
        }

        return MAX;
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {

        return addTwoNumbers(null, false, l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode head, boolean hasCarryOver, ListNode l1, ListNode l2) {
        // End of recursion
        if (l1 == null && l2 == null) {
            return head;
        }

        // Calculate sum and check whether there is carry over.
        int value = sum(l1, l2);
        if (hasCarryOver) value +=1;

        // Reset carry over
        hasCarryOver = false;
        if (value >= 10) {
            hasCarryOver = true;
            value = value - 10;
        }

        final ListNode current = new ListNode(value);
        // If Current is Null, make next head
        if (head == null) {
            head = current;
            return addTwoNumbers(head, hasCarryOver, nextOrNull(l1), nextOrNull(l2));
        }
        else {
            // else assign next to current.next
            getLast(head).next = current;
            return addTwoNumbers(head, hasCarryOver, nextOrNull(l1), nextOrNull(l2));
        }
    }

    public static ListNode getLast(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode last = head.next;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public static ListNode nextOrNull(ListNode listNode) {
        if (listNode == null) {
            return null;
        }

        return listNode.next;
    }
    public static int sum(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1.val;
        }

        return l2.val + l1.val;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; this.next = null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer("");
            sb.append(val);
            if (next != null) {
                sb.append(" -> ");
                sb.append(next);
            }


            return sb.toString();
        }
    }

}


