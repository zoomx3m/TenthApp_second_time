package com.example.asus.tenthapp.Utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.tenthapp.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<String> list;

    public RecyclerViewAdapter(List<String>list){
        this.list = list;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_list_item, viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        String title = list.get(i);
        viewHolder.list_item.setText(title);
        //animation for moving
        ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);

        viewHolder.linLay_4.setAnimation(null);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    // make interfce for MVH
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView list_item;
        private LinearLayout linLay_4;

        public MyViewHolder(View view) {
            super(view);
            list_item = (TextView)view.findViewById(R.id.list_item);
            linLay_4 = (LinearLayout)view.findViewById(R.id.linLay_4);
        }
    }
}
