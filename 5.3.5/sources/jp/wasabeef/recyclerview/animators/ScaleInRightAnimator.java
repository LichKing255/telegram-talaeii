package jp.wasabeef.recyclerview.animators;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.animation.Interpolator;

public class ScaleInRightAnimator extends BaseItemAnimator {
    public ScaleInRightAnimator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    protected void preAnimateRemoveImpl(ViewHolder holder) {
        ViewCompat.setPivotX(holder.itemView, (float) holder.itemView.getWidth());
    }

    protected void animateRemoveImpl(ViewHolder holder) {
        ViewCompat.animate(holder.itemView).scaleX(0.0f).scaleY(0.0f).setDuration(getRemoveDuration()).setInterpolator(this.mInterpolator).setListener(new DefaultRemoveVpaListener(holder)).setStartDelay(getRemoveDelay(holder)).start();
    }

    protected void preAnimateAddImpl(ViewHolder holder) {
        ViewCompat.setPivotX(holder.itemView, (float) holder.itemView.getWidth());
        ViewCompat.setScaleX(holder.itemView, 0.0f);
        ViewCompat.setScaleY(holder.itemView, 0.0f);
    }

    protected void animateAddImpl(ViewHolder holder) {
        ViewCompat.animate(holder.itemView).scaleX(1.0f).scaleY(1.0f).setDuration(getAddDuration()).setInterpolator(this.mInterpolator).setListener(new DefaultAddVpaListener(holder)).setStartDelay(getAddDelay(holder)).start();
    }
}
