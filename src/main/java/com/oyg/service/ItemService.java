package com.oyg.service;

import com.oyg.utils.EasyUIDataGridResult;

/**
 * Created by Green on 2018/1/8.
 */
public interface ItemService {

    EasyUIDataGridResult getItemList(int page, int rows);
}
