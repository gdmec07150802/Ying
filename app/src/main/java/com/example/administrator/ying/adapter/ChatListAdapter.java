package com.example.administrator.ying.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.ying.R;
import com.example.administrator.ying.entity.ChatListData;

import java.util.List;


/**
 * 对话adapter
 */
public class ChatListAdapter extends BaseAdapter{

    //写区分type
    //  左边
    public static final int LEFT_TEXT=1;
    //  右边
    public static final int RIGHT_TEXT=2;

    //上下文
    private Context mContext;
    private LayoutInflater inflater;
    //实体类
    private ChatListAdapter data;
    //数据源
    private List<ChatListData> mList;

    //构造方法
    public ChatListAdapter(Context mContext, List<ChatListData> mList){
        this.mContext=mContext;
        this.mList=mList;
        //获取系统服务
        inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //整个listview，adapter 核心内容
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewLeftText viewLeftText=null;
        ViewRightText viewRightText=null;
        //获取当前要显示的type，根据这个type来区分数据的加载
        int type=getItemViewType(position);
        if (convertView==null){
            //第一次初始化
            switch (type){
                case LEFT_TEXT:
                    //初始化左边
                    viewLeftText=new ViewLeftText();
                    //加载左边的item
                    convertView=inflater.inflate(R.layout.left_item,null);
                    //初始化
                    viewLeftText.tv_left_text= (TextView) convertView.findViewById(R.id.tv_left_text);
                    //放入
                    convertView.setTag(viewLeftText);
                    break;
                case RIGHT_TEXT:
                    viewRightText=new ViewRightText();
                    convertView=inflater.inflate(R.layout.right_item,null);
                    viewRightText.tv_right_text= (TextView) convertView.findViewById(R.id.tv_right_text);
                    convertView.setTag(viewRightText);
                    break;
            }
        }else {
            //第二次初始化
            switch (type) {
                case LEFT_TEXT:
                    viewLeftText= (ViewLeftText) convertView.getTag();
                    break;
                case RIGHT_TEXT:
                    viewRightText= (ViewRightText) convertView.getTag();
                    break;
            }
        }
        // 赋值
        ChatListData data=mList.get(position);
        switch (type){
            case LEFT_TEXT:
                viewLeftText.tv_left_text.setText(data.getText());
                break;
            case RIGHT_TEXT:
                viewRightText.tv_right_text.setText(data.getText());
        }
        return convertView;
    }

    //根据数据源的position来返回要显示的item  type怎么去拿
    @Override
    public int getItemViewType(int position) {
        ChatListData data=mList.get(position);
        int type=data.getType();
        return type;
    }
    //返回所有的layout数据

    @Override
    public int getViewTypeCount() {
        //mList.size+1
        return 3;
    }

    //左边的文本
    class ViewLeftText{
        private TextView tv_left_text;
    }
    //右边的文本
    class ViewRightText{
        private TextView tv_right_text;
    }
}
