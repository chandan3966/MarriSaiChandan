package com.example.marrisaichandan;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        ImgHolder holder1;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        ChatBubble chatbubble = getItem(position);
        int type=chatbubble.getType();
        int LayoutResource=0;
//        if (convertView!=null){
//            holder = (ViewHolder) convertView.getTag();
//        }
//        else{
        if (type == 1)
            LayoutResource = R.layout.rightchat;
        else if (type == 0)
            LayoutResource = R.layout.leftchat;
        else if (type == 3)
            LayoutResource = R.layout.rightimage;
        else if (type == 2)
            LayoutResource = R.layout.leftimage;
        else
            LayoutResource = R.layout.middle;
        convertView = inflater.inflate(LayoutResource,parent,false);

//        }
        if (type!=2 || type!=3){
            holder = new ViewHolder(convertView,chatbubble.getContent());
            convertView.setTag(holder);
            Log.d("hello", type+"");
//            holder.msg.setText(chatbubble.getContent());
        }
        else{
           holder1 = new ImgHolder(convertView);
           convertView.setTag(holder1);
            Log.d("hello", type+"");
//            holder1.img.setImageResource(Integer.parseInt(chatbubble.getContent()));
        }

        return convertView;
    }


    private class ViewHolder{
        public TextView msg;
        public ViewHolder(View v,String s){

            msg = (TextView) v.findViewById(R.id.txt_msg);
            msg.setText(s);
        }

    }

    private class ImgHolder{
        public ImageView img;
        public ImgHolder(View v){
            img = (ImageView) v.findViewById(R.id.img);
        }

    }

}
