package com.rdc.rdcwelcome.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.rdc.rdcwelcome.constant.Content;
import com.rdc.rdcwelcome.entiy.Group;
import com.rdc.rdcwelcome.R;
import com.rdc.rdcwelcome.utils.Typefaces;

import java.util.List;


/**
 * Created by 残渊 on 2018/11/8.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder>{

    private List<Group> mGroupList;
    private Context mContext;
    private ItemOnClick mItemOnClick;

    public  void setItemOnClick(ItemOnClick itemOnClick){
        mItemOnClick = itemOnClick;
    }

    public GroupAdapter(Context context,List<Group> groupList){
        mGroupList=groupList;
        mContext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Group group = mGroupList.get(position);
        holder.groupImg.setImageResource(group.getGroupImg());
        holder.groupName.setText(group.getGroupName());
        holder.groupName.setTextColor(mContext.getResources().getColor(Content.COLOR[position]));
        holder.groupName.setTypeface(Typefaces.get(mContext,"chinese.ttf"));
        holder.groupImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemOnClick.itemOnClick(position,v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGroupList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView groupImg;
        TextView groupName;
        public ViewHolder(View itemView) {
            super(itemView);
            groupImg = itemView.findViewById(R.id.img_bg);
            groupName = itemView.findViewById(R.id.tv_title);
        }
    }

   public interface ItemOnClick{
        void itemOnClick(int position,View view);
    }
}
