package com.jyeh.appletree;

public class BinarySearchTree<T extends Comparable> {
    private TreeNode<T> root;

    public void addNode(TreeNode<T> node) {
        addChild(root, node);
    }

    private void addChild(TreeNode<T> parent, TreeNode<T> child) {
        if (child.getValue().compareTo(parent.getValue()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                return;
            } else {
                addChild(parent.getLeft(), child);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(child);
                return;
            } else {
                addChild(parent.getRight(), child);
            }
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public void traverse(TreeNode<T> node, Visitor<TreeNode<T>> visitor) {
        if (node.getLeft() != null)
            traverse(node.getLeft(), visitor);
         visitor.visit(node);
        if (node.getRight() != null)
            traverse(node.getRight(), visitor);
    }
}
