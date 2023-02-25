package com.example.spring.data.jpa.tree.node.demo;

import com.example.spring.data.jpa.tree.node.domain.TreeNode;
import com.example.spring.data.jpa.tree.node.repository.TreeNodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TreeNodeDemo implements ApplicationRunner {

    private final TreeNodeRepository treeNodeRepository;

    @Override
    public void run(ApplicationArguments args) {
        TreeNode root = new TreeNode();

        // create child nodes
        TreeNode child1 = new TreeNode(root);
        TreeNode child2 = new TreeNode(root);

        root.addChildren(child1);
        root.addChildren(child2);

        // save nodes
        treeNodeRepository.save(root);
        treeNodeRepository.save(child1);
        treeNodeRepository.save(child2);
    }
}
