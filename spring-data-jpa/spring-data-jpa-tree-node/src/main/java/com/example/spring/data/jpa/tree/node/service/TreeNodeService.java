package com.example.spring.data.jpa.tree.node.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.spring.data.jpa.tree.node.repository.TreeNodeRepository;
import com.example.spring.data.jpa.tree.node.sdo.TreeNodeRdo;
import com.example.spring.data.jpa.tree.node.sdo.TreeNodeRdoListRdo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreeNodeService {

    private final TreeNodeRepository treeNodeRepository;

    public TreeNodeRdoListRdo findAll() {
        List<TreeNodeRdo> list = treeNodeRepository.findAll().stream()
            .map(TreeNodeRdo::new)
            .toList();
        return new TreeNodeRdoListRdo(list);
    }

    public TreeNodeRdo find(Long id) {
        return treeNodeRepository.findById(id)
            .map(TreeNodeRdo::new)
            .orElseThrow(() -> new NoSuchElementException("Not found treeNode. id: " + id));
    }
}
