package com.example.android.mvpapp2;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mvpapp2.entities.User;

import java.util.ArrayList;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {

    private ArrayList<User> users;
    private Context context;
    private ListItemClickListener listItemClickListener;

    public UserRecyclerAdapter(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recycler_item,parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserRecyclerAdapter.ViewHolder holder, int position) {

        User currentUser = users.get(position);
        holder.userImageView.setImageResource(R.mipmap.img_user);
        holder.userTV.setText(currentUser.getName() + " " + currentUser.getAddress() + currentUser.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView userTV;
        ImageView userImageView;

        public ViewHolder(View itemView){
            super(itemView);
            userImageView =(ImageView)itemView.findViewById(R.id.img_user);
            userTV = (TextView)itemView.findViewById(R.id.tv_names);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listItemClickListener != null) {
                listItemClickListener.OnItemClick(v, getAdapterPosition());
            }
        }
    }

    public void setListItemClickListener (ListItemClickListener listener) {
        this.listItemClickListener = listener;
    }

    public interface ListItemClickListener {
        void OnItemClick(View v, int position);
    }

}
