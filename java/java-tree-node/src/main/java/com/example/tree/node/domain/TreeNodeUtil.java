package com.example.tree.node.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreeNodeUtil {

    public static TreeNode createTreeNode(TreeNode parent, String nodeId) {
        TreeNode treeNode = new TreeNode(nodeId);
        parent.addChildren(treeNode);
        return treeNode;
    }
}
