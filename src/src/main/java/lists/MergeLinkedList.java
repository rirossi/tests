package lists;


import javax.swing.*;
import java.util.*;

/**
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
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
public class MergeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) { this(val, null); }
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

    public static void main(String[] argv) {
        ListNode one = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode two = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode three = new ListNode(2, new ListNode(6));

        //new ListNode[]{}
        System.out.println(sumLists(new ListNode[]{one, two, three}));
    }

    public static ListNode sumLists(ListNode[] elements) {
        if (elements.length == 0) {
            return null;
        }

        final List<Integer> values = new ArrayList<>();

        for (ListNode node : elements) {
            values.addAll(readValuesForNode(node));
        }

        values.sort((o1, o2) -> o1 - o2);

        return toListNode(values);
        // Build list from sorted values
    }

    public static ListNode toListNode(final List<Integer> values) {
        final ListNode head = new ListNode(values.get(0));
        ListNode last = head;

        for (int i =1; i<values.size(); i++) {
            ListNode current = new ListNode(values.get(i));
            last.next = current;
            last = current;
        }

        return head;
    }

    public static List<Integer> readValuesForNode(ListNode node) {
        final List<Integer> values = new ArrayList<>();
        ListNode current = node;
        values.add(current.val);
        // While has a next
        while (current.next != null) {
            current = current.next;
            values.add(current.val);
        }

        return values;
    }
}


