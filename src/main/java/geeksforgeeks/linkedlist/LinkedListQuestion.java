package main.java.geeksforgeeks.linkedlist;
class Node {

    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
public class LinkedListQuestion {

    public int findLengthByRecursion(Node node) {

        int len = 0;

        if (node == null)
            return len;
        else
            return 1 + findLengthByRecursion(node.next);

    }

    public int findLengthByIteration(Node node) {

        int len = 0;

        while (node != null) {
            node = node.next;
            len++;
        }

        return len;

    }

    public Node searchAnElementByRecursion(Node node, int data) {

        if (node == null)
            return null;
        else if (node != null && node.data == data)
            return node;
        else
            node = searchAnElementByRecursion(node.next, data);
        return node;

    }

    public Node searchAnElementByIteration(Node node, int data) {

        while (node != null && node.data != data ) {
            node = node.next;
        }
        return node;
    }

    public Node nthNodeFromEnd(Node node, int n) {

        int count = 0;
        Node p = node, q = node;
        while (q != null && count != n) {
            q = q.next;
            count++;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        return p;

    }

    public Node findMiddleNode(Node node) {

        Node p = node, q = node;

        while (q != null && q.next != null) {

            p = p.next;
            q = q.next.next;

        }

        return p;

    }

    public int findFrequencyOfNumber(Node node, int n) {

        int count = 0;
        while (node != null) {

            if (node.data == n)
                count++;

            node = node.next;

        }
        return count;

    }

    public boolean findLoop(Node node) {

        Node p = node, q = node;

        while (q != null && q.next != null) {

            p = p.next;
            q = q.next.next;

            if (p == q)
                break;

        }

        if (q == null || q.next == null)
            return false;
        else {
            countLengthOfLoop(p);
            return true;
        }

    }

    public void countLengthOfLoop(Node node) {

        Node temp = node;
        int count = 1;

        while (temp.next != node) {
            temp = temp.next;
            count++;
        }
        System.out.println(count);

    }

    public Node push(int data, Node head) {

        Node node  = new Node(data);
        head.next = node;
        return node;
    }

    public static void main(String[] args) {

        LinkedListQuestion fl = new LinkedListQuestion();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int N = arr.length;
        Node head = new Node(arr[0]);
        Node p = head;
        for (int i = 1; i < N; i++) {

            Node node = fl.push(arr[i], p);
            p = node;

        }

        System.out.println(fl.findLengthByRecursion(head));
        System.out.println(fl.findLengthByIteration(head));

        Node searchedNode = fl.searchAnElementByRecursion(head, 9);
        if (searchedNode == null)
            System.out.println("Not found");
        else
            System.out.println(searchedNode);

        searchedNode = fl.searchAnElementByIteration(head, 7);
        if (searchedNode == null)
            System.out.println("Not found");
        else
            System.out.println(searchedNode);

        searchedNode.next = head.next;
        //System.out.println(fl.nthNodeFromEnd(head, 4));

        //System.out.println(fl.findMiddleNode(head));

        //System.out.println(fl.findFrequencyOfNumber(head, 2));

        System.out.println(fl.findLoop(head));

    }

}
