package com.righttickk.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>{
    private ArrayList<RecyclerViewItem> mRecyclerViewList;

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mTextView3 = itemView.findViewById(R.id.textView3);
        }
    }

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> recyclerViewList) {
        mRecyclerViewList = recyclerViewList;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(v);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
        RecyclerViewItem currentItem = mRecyclerViewList.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.mTextView3.setText(currentItem.getText3());
    }

    @Override
    public int getItemCount() {
        return mRecyclerViewList.size();
    }
}
