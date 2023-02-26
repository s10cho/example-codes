package org.example.tree.node.domain;

import static org.example.core.util.JsonUtil.toJson;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeNode {

    private String id;

    private String parentId;

    private List<String> childrenIds;

    public TreeNode(String id) {
        this.id = id;
        this.childrenIds = new ArrayList<>();
    }

    public static TreeNode root() {
        return new TreeNode("root");
    }

    public void addChildren(TreeNode treeNode) {
        childrenIds.add(treeNode.getId());
        treeNode.changeParentId(id);
    }

    public void removeChildren(TreeNode treeNode) {
        childrenIds.remove(treeNode.getId());
    }

    public void changeParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
