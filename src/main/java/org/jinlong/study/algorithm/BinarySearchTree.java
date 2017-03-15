package org.jinlong.study.algorithm;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by nick on 15/03/2017.
 */
public class BinarySearchTree<K extends Comparable, V> {
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
                target = target.right;
            } else if (target.key.compareTo(key) > 0) {
                target = target.left;
            } else {
                break;
            }
        }
        if (target == null) {
            target = new Node(key, value);
        } else {
            target.value = value;
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

    public static void main(String[] args) {
        BinarySearchTree<String, Integer> binarySearchTree = new BinarySearchTree<String, Integer>();
        binarySearchTree.insert("My", 1);
        binarySearchTree.insert("Name", 1);
        binarySearchTree.insert("Is", 1);
        binarySearchTree.insert("Nick", 1);
        binarySearchTree.insert("!", 1);
        System.out.println(binarySearchTree.contains("My"));
        System.out.println(binarySearchTree.contains("my"));

    }
}
