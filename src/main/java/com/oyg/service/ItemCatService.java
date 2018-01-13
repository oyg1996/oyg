package com.oyg.service;

import com.oyg.utils.EasyUITreeNode;

import java.util.List;

/**
 * Created by Green on 2018/1/10.
 */
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(long parentId);
}
