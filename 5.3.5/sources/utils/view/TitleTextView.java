package utils.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TitleTextView extends TextView {
    private static Typeface defaultTypeface = null;
    public static final float scale = 1.2f;
    private static Typeface titleTypeface;

    public TitleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitleTextView(Context context) {
        super(context);
        init();
    }

    public static Typeface getTypeface(Context ctx) {
        if (defaultTypeface == null) {
            defaultTypeface = Typeface.createFromAsset(ctx.getAssets(), FontUtil.getDeafultTitleFontAddress());
        }
        return defaultTypeface;
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(getTypeface(getContext()));
            setTextSize(0, getTextSize() * 1.2f);
        }
    }
}
