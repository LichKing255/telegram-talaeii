package tellh.com.stickyheaderview_rv.adapter;

import android.support.v4.util.SparseArrayCompat;

public interface IViewBinderProvider {
    IViewBinder provideViewBinder(StickyHeaderViewAdapter stickyHeaderViewAdapter, SparseArrayCompat<? extends IViewBinder> sparseArrayCompat, int i);
}
