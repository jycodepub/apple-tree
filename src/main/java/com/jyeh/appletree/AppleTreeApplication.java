package com.jyeh.appletree;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
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
        int[] intArray = new int[] {7, 10, 10,5, 4, 20, 12, 8};
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
        AppleComparator comparator = (t, o) -> (int) Math.floor(t.getPrice() - o.getPrice());
        Apple[] apples = new Apple[] {
                new Apple("Fuji",4.99,1.,comparator),
                new Apple("PinkLady",5.99,1.,comparator),
                new Apple("GoldenCrispy",3.99,1.,comparator),
                new Apple("RedDelicious",6.99,1.,comparator)
        };

        BinarySearchTree<Apple> tree = new BinarySearchTree<>();
        tree.setRoot(new TreeNode<>(apples[0]));
        for (int i = 1; i < apples.length; i++) {
            tree.addNode(new TreeNode<>(apples[i]));
        }

        tree.traverse(tree.getRoot(), t -> System.out.println(t.getValue()));

        DoubleAdder sum = new DoubleAdder();
        tree.traverse(tree.getRoot(), node -> sum.add(node.getValue().getPrice()));
        System.out.println("Total Price: " + sum.doubleValue());

        Max max = new Max();
        tree.traverse(tree.getRoot(), node -> {
            if (node.getValue().getPrice() > max.max) max.max = node.getValue().getPrice();  });
        System.out.println(max.max);
    }

    private class Max {
        public double max = 0;
    }
}
