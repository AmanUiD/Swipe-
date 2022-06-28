package com.example.swipe;

import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swipe.Adapters.UserAdapter;
import com.example.swipe.Fragment.FolderFragment;
import com.example.swipe.Fragment.StarFragment;

public class RecyclerViewTouchHelper extends ItemTouchHelper.SimpleCallback {
    private FolderFragment listener;


    public RecyclerViewTouchHelper(int dragDirs, int swipeDirs, FolderFragment listener) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
    }

    public RecyclerViewTouchHelper(int dragDirs, int left, StarFragment starFragment) {
        super(dragDirs,left);
    }


    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if (listener != null) {
            listener.onSwiped(viewHolder);
        }
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null) {

            View foregroundView = ((UserAdapter.UserViewiewHolder) viewHolder).itemView.findViewById(R.id.forgroundLayout);
            getDefaultUIUtil().onSelected(foregroundView);
        }
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foregroundView = ((UserAdapter.UserViewiewHolder) viewHolder).itemView.findViewById(R.id.forgroundLayout);
   getDefaultUIUtil().onDrawOver(c, recyclerView,foregroundView, dX, dY, actionState, isCurrentlyActive);
    }


    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foregroundView = ((UserAdapter.UserViewiewHolder)viewHolder).itemView.findViewById(R.id.forgroundLayout);
        getDefaultUIUtil().onDraw(c, recyclerView,foregroundView, dX, dY, actionState, isCurrentlyActive);
    }
    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        View foregroundView = ((UserAdapter.UserViewiewHolder)viewHolder).itemView.findViewById(R.id.forgroundLayout);
    getDefaultUIUtil().clearView(foregroundView);
    }
}
