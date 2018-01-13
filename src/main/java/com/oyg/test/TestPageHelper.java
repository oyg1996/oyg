package com.oyg.test;

import com.github.pagehelper.PageHelper;
import com.oyg.dao.TbItemMapper;
import com.oyg.entity.TbItem;
import com.oyg.entity.TbItemExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Green on 2018/1/5.
 */
public class TestPageHelper {

    @Test
    public void testPagehelper(){
        //初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        //从容器中获得mapper代理对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        //执行查询
        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(1.30);
        List<TbItem> list = itemMapper.selectByExample(example);
        //取分页消息
        System.out.println("结果集中的记录数："+list.size());

    }
}
