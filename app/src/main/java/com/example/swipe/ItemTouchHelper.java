package com.example.swipe;

import androidx.recyclerview.widget.RecyclerView;

public interface ItemTouchHelper {
    void onSwiped(RecyclerView.ViewHolder viewHolder);
}
