package com.example.marrisaichandan;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<ChatBubble> {

    public Activity activity;
    int LayoutResource;
    public List<ChatBubble> messages;

    public MessageAdapter(Activity context, int resource, List<ChatBubble> objects) {
        super(context, resource,objects);
        this.activity = context;
        this.messages = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        ChatBubble chatbubble = getItem(position);
        int type=chatbubble.getType();
        int LayoutResource=0;
//        if (convertView!=null){
//            holder = (ViewHolder) convertView.getTag();
//        }
//        else{
        if (type == 0)
            LayoutResource = R.layout.rightchat;
        else
            LayoutResource = R.layout.leftchat;
        convertView = inflater.inflate(LayoutResource,parent,false);
        holder = new ViewHolder(convertView);
        convertView.setTag(holder);
        Log.d("hello", type+"");
//        }
        holder.msg.setText(chatbubble.getContent());
        return convertView;
    }


    private class ViewHolder{
        public TextView msg;
        public ViewHolder(View v){

            msg = (TextView) v.findViewById(R.id.txt_msg);
        }

    }
}
