package org.example.tree.node.domain;

import static org.example.tree.node.domain.TreeNodeUtil.createTreeNode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class TreeNodeTest {

    @Test
    void treeNodeTest() {
        TreeNode root = TreeNode.root();

        TreeNode node01 = new TreeNode("node01");
        TreeNode node02 = new TreeNode("node02");
        TreeNode node03 = new TreeNode("node03");

        root.addChildren(node01);
        root.addChildren(node02);
        root.addChildren(node03);

        log.info("root: {}", root);
        log.info("node01: {}", node01);
        log.info("node02: {}", node02);
        log.info("node03: {}", node03);
    }

    @Test
    void treeNodeUtilTest() {
        TreeNode root = TreeNode.root();

        TreeNode node01 = createTreeNode(root, "node01");
        TreeNode node02 = createTreeNode(root, "node02");
        TreeNode node03 = createTreeNode(root, "node03");

        log.info("root: {}", root);
        log.info("node01: {}", node01);
        log.info("node02: {}", node02);
        log.info("node03: {}", node03);
    }
}
