package main.java.geeksforgeeks.linkedlist;

import java.util.ArrayList;
import java.util.List;

class Pair {

    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
class LinkedListNode {

    int data;
    LinkedListNode next;
    LinkedListNode random;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "data=" + data +
                ", next=" + next.data +
                ", random=" + random.data +
                '}';
    }
}
public class DuplicateLinkedList {

    public LinkedListNode createLinkedList(int[] arr, List<Pair> randomRef) {

        LinkedListNode head = new LinkedListNode(arr[0]);

        LinkedListNode tmp = head;

        for (int i = 1; i < arr.length; ++i) {

            tmp = push(arr[i], tmp);

        }
        return null;
    }

    public LinkedListNode createDuplicateLinkedList(LinkedListNode head) {

return null;
    }

    public LinkedListNode push(int data, LinkedListNode head) {

        LinkedListNode node  = new LinkedListNode(data);
        head.next = node;
        return node;
        
    }

    public static void main(String[] args) {

        DuplicateLinkedList duplicateLinkedList = new DuplicateLinkedList();
        int[] arr = {1,2,3,4};
        List<Pair> randomRef = new ArrayList<>();
        randomRef.add(new Pair(1,3));
        randomRef.add(new Pair(2,1));
        randomRef.add(new Pair(3,3));
        randomRef.add(new Pair(4,2));
        LinkedListNode head = duplicateLinkedList.createDuplicateLinkedList(duplicateLinkedList.createLinkedList(arr, randomRef));

        System.out.println(head);

    }

}
