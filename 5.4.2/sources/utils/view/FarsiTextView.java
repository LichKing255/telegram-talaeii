package utils.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.C0855y;
import android.util.AttributeSet;

public class FarsiTextView extends C0855y {
    /* renamed from: a */
    private static Typeface f10274a;

    public FarsiTextView(Context context) {
        super(context);
        m14169a();
    }

    public FarsiTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14169a();
    }

    public FarsiTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14169a();
    }

    /* renamed from: a */
    public static Typeface m14168a(Context context) {
        if (f10274a == null) {
            f10274a = Typeface.createFromAsset(context.getAssets(), FontUtil.m14170a());
        }
        return f10274a;
    }

    /* renamed from: a */
    private void m14169a() {
        if (!isInEditMode()) {
            setTypeface(m14168a(getContext()));
            setTextSize(0, getTextSize() * 1.2f);
        }
    }
}
