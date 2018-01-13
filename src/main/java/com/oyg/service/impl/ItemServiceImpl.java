package com.oyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oyg.dao.TbItemMapper;
import com.oyg.entity.TbItem;
import com.oyg.entity.TbItemExample;
import com.oyg.service.ItemService;
import com.oyg.utils.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Green on 2018/1/8.
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //开起分页
        PageHelper.startPage(page, rows);
        //分页处理
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建返回结果对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        //查询总记录数
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
