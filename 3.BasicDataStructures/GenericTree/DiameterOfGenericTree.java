// 1. You are given a partially written GenericTree class.
// 2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree. Check the question video for clarity.
// 3. Input is managed for you.

import java.io.*;
import java.util.*;

public class DiameterOfGenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        magic(root);
        System.out.println(diameter);

    }

    static int diameter = 0;

    public static int magic(Node node) {
        int deepestN = -1;
        int sDeepestN = -1;

        for (Node child : node.children) {
            int currentChildHeight = magic(child);

            if (currentChildHeight > deepestN) {
                sDeepestN = deepestN;
                deepestN = currentChildHeight;
            } else if (currentChildHeight > sDeepestN) {
                sDeepestN = currentChildHeight;
            }
        }

        int candidate = deepestN + sDeepestN + 2;

        if (candidate > diameter) {
            diameter = candidate;
        }
        return deepestN + 1;

    }

}
