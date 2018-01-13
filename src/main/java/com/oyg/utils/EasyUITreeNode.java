package com.oyg.utils;

/**
 * 描述tree节点信息
 * Created by Green on 2018/1/10.
 */
public class EasyUITreeNode {
    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getState(String s) {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
