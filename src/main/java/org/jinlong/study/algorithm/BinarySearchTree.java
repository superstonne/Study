package org.jinlong.study.algorithm;

import java.util.*;

/**
 * Created by nick on 15/03/2017.
 */
public class BinarySearchTree<K extends Comparable, V> {
    private Stack<Node> stack = new Stack<Node>();
    private int count = 0;
    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        Node target = root;
        while (target != null) {
            if (target.key.compareTo(key) < 0) {
                if (target.right == null) {
                    target.right = new Node(key, value);
                    break;
                } else {
                    target = target.right;
                }
            } else if (target.key.compareTo(key) > 0) {
                if (target.left == null) {
                    target.left = new Node(key, value);
                    break;
                } else {
                    target = target.left;
                }
            } else {
                target = new Node(key, value);
                break;
            }
        }
    }

    public boolean contains(K key) {
        if (root == null) {
            return false;
        }
        Node target = root;
        while (target != null) {
            if (target.key.compareTo(key) < 0) {
                target = target.right;
                continue;
            } else if (target.key.compareTo(key) > 0) {
                target = target.left;
                continue;
            }
            return true;
        }
        return false;
    }

    public List<K> preOrder(Node node, List<K> result) {
        if (node == null) {
            return result;
        }
        result.add(node.key);
        result = preOrder(node.left, result);
        result = preOrder(node.right, result);
        return result;
    }

    public List<K> inOrder(Node node, List<K> result) {
        if (node == null) {
            return result;
        }
        result = inOrder(node.left, result);
        result.add(node.key);
        result = inOrder(node.right, result);
        return result;
    }

    public List<K> postOrder(Node node, List<K> result) {
        if (node == null) {
            return result;
        }
        result = postOrder(node.left, result);
        result = postOrder(node.right, result);
        result.add(node.key);
        return result;
    }

    public List<K> breathFirstSearch(Node node, List<K> result) {
        if (node == null) {
            return result;
        }
        stack.push(node);
        while (!stack.empty()) {
            Node temp = stack.pop();
            result.add(temp.key);
            stack.push(temp.left);
            stack.push(temp.right);
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
        int[] data = Util.generateRandomArray(10, 100);
        for (int num : data) {
            binarySearchTree.insert(num, 0);
            System.out.println("Inserted num:" + num);
        }
        List<Integer> result = new ArrayList<Integer>();
        result = binarySearchTree.preOrder(binarySearchTree.root, result);
        System.out.println(result);
        result.clear();
        result = binarySearchTree.inOrder(binarySearchTree.root, result);
        System.out.println(result);
        result.clear();
        result = binarySearchTree.postOrder(binarySearchTree.root, result);
        System.out.println(result);
    }
}
