package com.example.spring.data.jpa.tree.node.sdo;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreeNodeRdoListRdo {

    private List<TreeNodeRdo> list;
}
