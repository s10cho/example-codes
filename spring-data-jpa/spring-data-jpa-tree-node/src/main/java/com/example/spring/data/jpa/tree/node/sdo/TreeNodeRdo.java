package com.example.spring.data.jpa.tree.node.sdo;

import java.util.List;

import com.example.spring.data.jpa.tree.node.domain.TreeNode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeNodeRdo {

    private Long id;

    private Long parentId;

    private List<Long> childrenIds;

    public TreeNodeRdo(TreeNode treeNode) {
        this.id = treeNode.getId();
        this.parentId = treeNode.getParentId();
        this.childrenIds = treeNode.getChildren().stream()
            .map(TreeNode::getId)
            .toList();
    }
}
