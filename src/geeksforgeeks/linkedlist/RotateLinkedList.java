package geeksforgeeks.linkedlist;

/**
 * Not Completed
 */
class Node {

    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }
}
public class RotateLinkedList {

    public static void main(String[] args) {

        int arr[] = {1, 2};
        int N = arr.length;


        RotateLinkedList rll = new RotateLinkedList();
        Node head = new Node(arr[0]);
        Node p = head;
        for (int i = 1; i < N; i++) {

            Node node = rll.push(arr[i], p);
            p = node;

        }

        Node tmp = rll.rotate(head, 4);
        rll.show(tmp);

    }

    public Node push(int data, Node head) {

        Node node  = new Node(data);
        head.next = node;
        return node;
    }

    public void show(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }

    public Node rotate(Node head, int k) {

        Node p = head, q = head;
        int count = k;
        while (--count > 0) {
            if (q == null)
                return head;
            q = q.next;
        }
        head = q.next;
        q.next = null;
        q = head;

        while (q.next != null)
            q = q.next;

        q.next = p;

        return head;

    }

}
