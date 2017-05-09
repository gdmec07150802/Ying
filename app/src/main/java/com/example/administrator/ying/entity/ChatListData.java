package com.example.administrator.ying.entity;

/**
 * 对话列表的实体类
 */
public class ChatListData {

    //type：区分左右边
    private int type;
    //文本
    private String text;

    //重写get,set方法
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
