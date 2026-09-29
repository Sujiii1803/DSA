package Recursion.leetcode;

public class RemoveLinkedListElements_203 {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {

        public ListNode removeElements(ListNode head, int val) {

            // Base case
            if (head == null) {
                return null;
            }

            // Recursively process the remaining list
            head.next = removeElements(head.next, val);

            // Remove current node if value matches
            if (head.val == val) {
                return head.next;
            }

            return head;
        }
    }

    // Print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Input: [1,2,6,3,4,5,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int val = 6;

        System.out.print("Original list: ");
        printList(head);

        head = solution.removeElements(head, val);

        System.out.print("After removing " + val + ": ");
        printList(head);
    }
}