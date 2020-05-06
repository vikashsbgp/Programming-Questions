package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Node {
    int key, height, size;
    Node left, right;

    Node(int key) {
        this.key = key;
        this.height = 1;
        this.size = 1;
    }
}

public class InversionOfArray {

    private int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(str[i]);

            InversionOfArray obj = new InversionOfArray();

//            System.out.print(obj.inversionOfArrayUsingMergeSort(arr, n));
            obj.result = 0;
            System.out.print(obj.inversionOfArrayUsingAvlTree(arr, n));

            if (t != 0)
                System.out.println();
        }

    }

    private int inversionOfArrayUsingAvlTree(int[] arr, int n) {

        Node root = new Node(arr[0]);
        for (int i = 1; i < n; ++i) {
            root = insert(root, arr[i]);
        }
        return result;
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return node.size;
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private Node insert(Node node, int key) {

        if (node == null)
            return new Node(key);
        if (key < node.key) {
            node.left = insert(node.left, key);
            result += size(node.right) + 1;
        }
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        node.size = size(node.left) + size(node.right) + 1;

        int balance = getBalance(node);

        //left left case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // right right case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        //left right case
        if (balance > 1 && key > node.left.key) {
            node = leftRotate(node);
            return rightRotate(node);
        }

        //right left case
        if (balance < -1 && key < node.right.key) {
            node = rightRotate(node);
            return leftRotate(node);
        }

        return node;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        y.size = size(y.left) + size(y.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.size = size(x.left) + size(x.right) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        y.size = size(y.left) + size(y.right) + 1;

        return y;

    }



    public int inversionOfArrayUsingMergeSort(int[] arr, int n) {
        return mergeSortAndCount(arr, 0, n - 1);
    }

    public int mergeSortAndCount(int[] arr, int l, int r) {

        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    private int mergeAndCount(int[] arr, int l, int m, int r) {

        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

}
