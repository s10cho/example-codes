package com.example.spring.data.jpa.tree.node.controller;

import com.example.spring.data.jpa.tree.node.sdo.TreeNodeRdo;
import com.example.spring.data.jpa.tree.node.sdo.TreeNodeRdoListRdo;
import com.example.spring.data.jpa.tree.node.service.TreeNodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("nodes")
public class TreeNodeResource {

    private final TreeNodeService treeNodeService;

    @GetMapping
    public TreeNodeRdoListRdo findAll() {
        return treeNodeService.findAll();
    }

    @GetMapping("{id}")
    public TreeNodeRdo find(
        @PathVariable Long id
    ) {
        return treeNodeService.find(id);
    }
}
