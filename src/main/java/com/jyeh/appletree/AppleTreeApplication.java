package com.jyeh.appletree;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;

@SpringBootApplication
public class AppleTreeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppleTreeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        integerTree();
        appleTree();
    }

    private void integerTree() {
        int[] intArray = new int[] {7, 10, 5, 4, 20, 12, 8};
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.setRoot(new TreeNode<>(intArray[0]));
        for (int i = 1; i < intArray.length; i++) {
            tree.addNode(new TreeNode<>(intArray[i]));
        }
        TreeNode<Integer> root = tree.getRoot();

        tree.traverse(root, n -> System.out.println(n.getValue()));

        final AtomicInteger sum = new AtomicInteger();
        tree.traverse(root,  n -> sum.addAndGet(n.getValue()));
        System.out.println("total=" + sum.get());

        AtomicInteger max = new AtomicInteger();
        tree.traverse(tree.getRoot(), n -> { if (n.getValue() > max.get()) max.set(n.getValue()); });
        System.out.println("Max=" + max.get());
    }

    private void appleTree() {
    }
}
