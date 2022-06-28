package com.example.swipe.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.swipe.Adapters.UserAdapter;
import com.example.swipe.R;
import com.example.swipe.RecyclerViewTouchHelper;
import com.example.swipe.model.User;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class FolderFragment extends Fragment implements com.example.swipe.ItemTouchHelper {
    private RecyclerView swipeRV;
    private UserAdapter adapter;
    private List<User> userList;
    private FrameLayout rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_folder, container, false);
        swipeRV = view.findViewById(R.id.swipeRV);
        rootView = view.findViewById(R.id.root_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        swipeRV.setLayoutManager(layoutManager);
        userList = getUserList();
        adapter = new UserAdapter(userList);
        swipeRV.setAdapter(adapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        swipeRV.addItemDecoration(itemDecoration);
        ItemTouchHelper.SimpleCallback simpleCallback = new RecyclerViewTouchHelper(0, ItemTouchHelper.LEFT,this);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(swipeRV);
        return view;
    }

    private List<User> getUserList() {
        List<User> list = new ArrayList<>();

        list.add(new User("Flipkart", "Your cart miss you", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.flipkart,   R.drawable.ic_star));
        list.add(new User("LinkedIn", "You have a message", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.linkedin,   R.drawable.ic_star));
        list.add(new User("Lenskart", "Your cart miss you", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.lenskart,   R.drawable.ic_star));
         list.add(new User("Flipkart", "Your cart miss you", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.flipkart,   R.drawable.ic_star));
        list.add(new User("LinkedIn", "You have a message", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.linkedin,   R.drawable.ic_star));
        list.add(new User("Lenskart", "Your cart miss you", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.lenskart,   R.drawable.ic_star));
         list.add(new User("Flipkart", "Your cart miss you", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.flipkart,   R.drawable.ic_star));
        list.add(new User("LinkedIn", "You have a message", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.linkedin,   R.drawable.ic_star));
        list.add(new User("Lenskart", "Your cart miss you", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.lenskart,   R.drawable.ic_star));
         list.add(new User("Flipkart", "Your cart miss you", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.flipkart,   R.drawable.ic_star));
        list.add(new User("LinkedIn", "You have a message", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.linkedin,   R.drawable.ic_star));
        list.add(new User("Lenskart", "Your cart miss you", "Hurry up, ther are other looking for big deal..", "1:23am", R.drawable.lenskart,   R.drawable.ic_star));
          return list;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder) {
       if (viewHolder instanceof  UserAdapter.UserViewiewHolder){
           String nameUserDelete = userList.get(viewHolder.getAdapterPosition()).getName();

           User userDelete = userList.get(viewHolder.getAdapterPosition());
           int indexDelete =viewHolder.getAdapterPosition();

           //remove item
           adapter.removeItem(indexDelete);
           Snackbar snackbar = Snackbar.make(rootView,"1 archive", Snackbar.LENGTH_LONG);
           snackbar.setAction("UNDO", new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   adapter.undoItem(userDelete, indexDelete);

               }
           });
           snackbar.setActionTextColor(Color.WHITE);
           snackbar.show();
       }
    }
}