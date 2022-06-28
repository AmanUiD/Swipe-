package com.example.swipe.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swipe.R;
import com.example.swipe.model.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewiewHolder>{

   private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewiewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swiperv, parent, false);
        return new UserViewiewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewiewHolder holder, int position) {
        User user = userList.get(position);
        if (user == null){
            return;
        }
        holder.Name.setText(user.getName());
        holder.Title.setText(user.getTitle());
        holder.Message.setText(user.getMessage());
        holder.Time.setText(user.getTime());
        holder.profile.setImageResource(user.getProfile());


        holder.favourite.setImageResource(user.getFavourite());

    }

    @Override
    public int getItemCount() {
        if (userList != null){
            return userList.size();
        }
        return 0;
    }

    public class UserViewiewHolder extends RecyclerView.ViewHolder{

        TextView Name, Title, Time, Message;
        CircleImageView profile;
        ImageView   favourite;
        RelativeLayout foregroundLayout;

        public UserViewiewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Title = itemView.findViewById(R.id.Title);
            Time = itemView.findViewById(R.id.Time);
            Message = itemView.findViewById(R.id.Message);
            profile = itemView.findViewById(R.id.profile);


            favourite = itemView.findViewById(R.id.favourite);
            foregroundLayout = itemView.findViewById(R.id.forgroundLayout);

        }
    }
    public void removeItem(int index){
        userList.remove(index);
        notifyItemRemoved(index);
    }
    public void undoItem(User user, int index){
        userList.add(index, user);
        notifyItemInserted(index);
    }
}
