package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder;

public abstract class AbstractExpandableItemViewHolder extends ViewHolder implements ExpandableItemViewHolder {
    private int mExpandStateFlags;

    public AbstractExpandableItemViewHolder(View itemView) {
        super(itemView);
    }

    public void setExpandStateFlags(int flags) {
        this.mExpandStateFlags = flags;
    }

    public int getExpandStateFlags() {
        return this.mExpandStateFlags;
    }
}
