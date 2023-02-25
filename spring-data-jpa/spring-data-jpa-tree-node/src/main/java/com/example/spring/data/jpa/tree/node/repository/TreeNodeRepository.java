package com.example.spring.data.jpa.tree.node.repository;

import com.example.spring.data.jpa.tree.node.domain.TreeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeNodeRepository extends JpaRepository<TreeNode, Long> {
}
