package com.jyeh.appletree;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TreeNode<T extends Comparable> {
    private final T value;
    private TreeNode left;
    private TreeNode right;
}
