package pl.janek;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Main {

    public static void main(String[] args) {
       var v2 = new ListNode(2);
       var hd = new ListNode(1, v2);
        System.out.println(isPalindrome(hd));

    }

    public static boolean isPalindrome(ListNode head) {
        StringBuilder str = new StringBuilder();
        ListNode current = head;
        while(current != null){
            str.append(current.val);
            current = current.next;
        }
        String normal = String.valueOf(str);
        String reversed = String.valueOf(str.reverse());
        System.out.println(normal);
        System.out.println(str);
        return normal.equals(reversed);

    }
}
